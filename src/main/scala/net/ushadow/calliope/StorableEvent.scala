package net.ushadow.calliope

import com.google.appengine.api.datastore.Entity
import scala.collection.JavaConversions._

class StorableEvent(private val entity: Entity) extends Event {
	override def kind = entity.getKind
	def properties: Map[String, Object] = entity.getProperties.toMap
	override def hasProperty(name: String) = entity.hasProperty(name)
	override def getProperty(name: String) = entity.getProperty(name)
}