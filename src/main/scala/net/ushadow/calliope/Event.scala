package net.ushadow.calliope

import com.google.appengine.api.datastore.Entity

/**
 * An event can not be modified.
 */
class Event(private val payload: Entity) {

	def kind = payload.getKind

	def apply[T](name: String): Option[Object] = {
		if (payload.hasProperty(name)) {
			Some(payload.getProperty(name))
		} else {
			None
		}
	}
	
}