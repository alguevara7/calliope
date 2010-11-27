package net.ushadow.calliope

class UShadow(
	val world: World, 
	val activities: List[Activity]) {
	
	def receive(event: Event) = {
		for (activity <- activities) { 
			activity.process(event) match {
				case Some(action) => action.apply(world)
				case None =>
			}
		}
	}

}