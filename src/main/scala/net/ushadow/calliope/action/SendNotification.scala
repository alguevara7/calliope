package net.ushadow.calliope.action

import net.ushadow.calliope._

class SendNotification(
	recipient: String,
	message: String
  ) extends Action {
	
  def apply(world: World): Unit = {  
	  world.sendNotification(recipient, message)
  }

}