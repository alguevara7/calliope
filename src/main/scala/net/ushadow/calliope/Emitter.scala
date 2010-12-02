package net.ushadow.calliope

import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.labs.taskqueue.QueueFactory
import com.google.appengine.api.labs.taskqueue.Queue
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
      queue.add(url("/tasks/dispatcher").param("key", KeyFactory.keyToString(key)))
      transaction.commit
    } catch {
      case _: DatastoreFailureException => transaction.rollback
    }
    
    //TODO notify caller on exception
    
  }

  private def copyProperties(event: Event, entity: Entity) {
    for ((name, value) <- event.properties) {
      entity.setProperty(name, value)
    }
  }

}