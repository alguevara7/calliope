package net.ushadow.calliope

trait Activity {

	def process(event: Event): Option[Action]

}