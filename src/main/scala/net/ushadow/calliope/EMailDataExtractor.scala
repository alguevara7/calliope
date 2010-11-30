package net.ushadow.calliope

import java.util.Date
import org.joda.time.DateTime

trait EMailDataExtractor extends CoreDataExtractor {
	
	def sentOn: Option[DateTime] = event("sentOn") match {
		case Some(obj) => if (obj.isInstanceOf[Date]) Some(new DateTime(obj.asInstanceOf[Date])) else None
		case None => None
	}
	
	def from: Option[String] = event("from") match {
		case Some(obj) => if (obj.isInstanceOf[String]) Some(obj.asInstanceOf[String]) else None
		case None => None
	}
	
	def get[T<:Object](name: String): Option[T] = event("from") match {
		case Some(obj) => if (obj.isInstanceOf[T]) Some(obj.asInstanceOf[T]) else None
		case None => None
	}
	

}