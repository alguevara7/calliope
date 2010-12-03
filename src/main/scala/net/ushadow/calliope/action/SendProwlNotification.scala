package net.ushadow.calliope.action

import net.ushadow.calliope._

class SendProwlNotification(
	subject: String,
	message: String
  ) extends Action {
	
  def apply(world: World): Unit = {  
	  world.sendProwlNotification(subject, message)
  }

}