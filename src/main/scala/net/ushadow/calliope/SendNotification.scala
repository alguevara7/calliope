package net.ushadow.calliope

class SendNotification(
	recipient: String,
	message: String
  ) extends Action {
	
  def apply(world: World): Unit = {  
	  world.sendNotification(recipient, message)
  }

}