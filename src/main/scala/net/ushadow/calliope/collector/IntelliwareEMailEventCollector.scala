package net.ushadow.calliope.collector

import net.ushadow.calliope._
import java.util.Properties
import java.util.Date
import javax.mail.Session

class IntelliwareEMailEventCollector(
		private val username: String,
		private val password: String) extends EventCollector {

	def collect: List[Event] = {
//HttpParams httpParams = new BasicHttpParams();
//ClientConnectionManager connectionManager = new GAEConnectionManager();
//HttpClient httpClient = new DefaultHttpClient(connectionManager, httpParams);		
		
		//java mail
		return List(new InMemoryEvent("e-mail", Map("from" -> "alexguev@gmail.com", "sentOn" -> new Date())))
	}
	
}
	
object IntelliwareEMailEventCollector {
  def main(args: Array[String]) {
        val session = Session.getInstance(new Properties())
        val store = session.getStore("pop3")
        val storeClass = store.getClass().getName();
        System.out.println("POP3 Store provider class is \"" + storeClass + "\".")
//        val transport = session.getTransport("smtp")
//        val transportClass = transport.getClass().getName()
//        System.out.println("SMTP Transport provider class is \"" + transportClass + "\".")

  }
}
	
