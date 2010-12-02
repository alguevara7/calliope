package net.ushadow.calliope

import com.google.appengine.api.datastore.Entity

class EventThatIsStorable(private val entity: Entity) extends Event {
	override def kind = entity.getKind
	override def hasProperty(name: String) = entity.hasProperty(name)
	override def getProperty(name: String) = entity.getProperty(name)
}