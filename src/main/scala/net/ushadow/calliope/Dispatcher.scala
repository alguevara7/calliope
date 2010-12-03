package net.ushadow.calliope

import net.ushadow.calliope.activity._

class Dispatcher {
	
	private val ushadow = new UShadow(
			new World, 
			List(new SendNotificationUponReceivingEmail("alexguev@gmail.com", null)))
	
	def dispatch(event: Event) {
		ushadow.receive(event)
	}

}