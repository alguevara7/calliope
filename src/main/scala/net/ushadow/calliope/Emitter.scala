package net.ushadow.calliope

import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.labs.taskqueue._
import com.google.appengine.api.labs.taskqueue.TaskOptions._
import com.google.appengine.api.datastore.DatastoreFailureException
import com.google.appengine.api.datastore.DatastoreServiceFactory
import com.google.appengine.api.datastore.Entity
import com.google.appengine.api.labs.taskqueue.TaskOptions.Builder._;

class Emitter {

  def emit(event: Event) {
    val entity = new Entity(event.kind)
    copyProperties(event, entity)

    val datastore = DatastoreServiceFactory.getDatastoreService();
    val transaction = datastore.beginTransaction
    try {
      val key = datastore.put(entity)
      val queue = QueueFactory.getQueue("dispatcher-queue")
      queue.add(transaction, url("/tasks/dispatcher").method(Method.GET).param("key", KeyFactory.keyToString(key)))
      transaction.commit
    } finally {
      if (transaction.isActive) {
        transaction.rollback
      }
    }

  }

  private def copyProperties(event: Event, entity: Entity) {
    for ((name, value) <- event.properties) {
      entity.setProperty(name, value)
    }
  }

}