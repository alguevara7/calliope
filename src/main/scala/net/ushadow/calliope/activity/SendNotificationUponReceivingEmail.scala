package net.ushadow.calliope.activity

import net.ushadow.calliope._
import net.ushadow.calliope.action._
import java.util.Date
import org.joda.time.Interval
import org.joda.time._

class SendNotificationUponReceivingEmail(
  from: String,
  when: Interval) extends Activity {

//depend on matcher and action factory
	
  class DataExtractor(protected val event: Event) extends EMailDataExtractor {}
  
  implicit def RichInterval(interval: Interval) = new RichInterval(interval)

  def process(event: Event): Option[Action] = {
    //FUN use pattern matching
	  
    val extractor = new DataExtractor(event)
    
    if (extractor.kind == "e-mail" 
     && (extractor.from.getOrElse("") == "dan.light@intelliware.ca" || extractor.from.getOrElse("") == "alexei.guevara@intelliware.ca")
     && new Interval(new DateTime().withHourOfDay(20).withMinuteOfHour(0), new DateTime().withHourOfDay(23).withMinuteOfHour(59)).contains(extractor.sentOn)) {
      Some(new SendProwlNotification("important e-mail received", "an e-mail sent from: " + extractor.from.getOrElse("Unknown") + " has been received"))
    } else {
      None
    }

  }

}

class RichInterval(private val interval: Interval) {
  def contains(optionalInstant: Option[DateTime]) = optionalInstant match {
    case Some(instant) => interval.contains(instant)
    case None => false
  }
}