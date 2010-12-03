package net.ushadow.calliope.activity

import net.ushadow.calliope._
import net.ushadow.calliope.action._
import java.util.Date
import org.joda.time._

//depend on matcher and action factory

class RichInterval(private val interval: Interval) {
  def contains(optionalInstant: Option[ReadableInstant]) = optionalInstant match {
    case Some(instant) => interval.contains(instant)
    case None => false
  }
}

object RichInterval {
  implicit def RichInterval(interval: Interval) = new RichInterval(interval)
}

class SendNotificationUponReceivingEmail(
  from: String,
  when: Interval) extends Activity {

  class DataExtractor(protected val event: Event) extends EMailDataExtractor {}

  def process(event: Event): Option[Action] = {
    //use pattern matching
    val extractor = new DataExtractor(event)
    if (extractor.kind == "e-mail") {
      Some(new SendNotification("alexei's iphone", "send computer email"))
    } else {
      None
    }

  }

}