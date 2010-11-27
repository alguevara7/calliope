package net.ushadow.calliope

class UShadow(val activities: List[Activity]) {
	
	def receive(event: Object) = {
		for (activity <- activities) activity.process(event) 
	}

}