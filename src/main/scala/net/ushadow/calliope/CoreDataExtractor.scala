package net.ushadow.calliope

trait CoreDataExtractor {
	
	protected val event: Event

	def kind: String = {
		event.kind
	}
	
}
