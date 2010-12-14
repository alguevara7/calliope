package net.ushadow.calliope

import java.util.Date
import org.joda.time.DateTime
import net.ushadow.calliope.extractor.CoreDataExtractor
import net.ushadow.calliope.extractor.CoreDataExtractor._

trait EMailDataExtractor extends CoreDataExtractor {
	def sentOn: Option[DateTime] = get[Date, DateTime](event, "sentOn") 
	def from: Option[String] = get[String, String](event, "from")
}