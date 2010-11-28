package net.ushadow.calliope

import java.util.Date

class SendNotificationUponReceivingEmail(
	from: String,
	when: DateRange
  ) extends Activity {

  def process(event: Event): Option[Action] = {
    val extractor = new EMailDataExtractor(event)
	
	None
  }

}