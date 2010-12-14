package net.ushadow.calliope.extractor

import net.ushadow.calliope._
import org.joda.time.DateTime
import java.util.Date

trait CoreDataExtractor {
	
	protected val event: Event

	def kind: String = {
		event.kind
	}

}

object CoreDataExtractor {
	implicit val dateToDateTime = new Function1[Date, DateTime] {
		def apply(value: Date): DateTime = new DateTime(value)
	} 
	
	def get[T<:Object, R<:Object](
			event: Event, name: String) 
			(implicit transformer: T => R): Option[R] = event(name) match {
		case Some(obj) => if (obj.isInstanceOf[T]) Some(transformer(obj.asInstanceOf[T])) else None
		case None => None
	}
}