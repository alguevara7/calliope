package net.ushadow.calliope.web

import org.apache.commons.io.IOUtils
import javax.mail.Multipart
import javax.mail.internet.MimeMessage
import javax.mail.Session
import java.util.Properties
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServlet

class MailHandlerServlet extends HttpServlet {

	
  override def doPost(req: HttpServletRequest, resp: HttpServletResponse) = {
	  val props = new Properties
      val session = Session.getDefaultInstance(props, null)
      val message = new MimeMessage(session, req.getInputStream)
      val content = message.getContent.asInstanceOf[Multipart]
	  for (i <- 1 to content.getCount-1) {
	 	  val part = content.getBodyPart(i)
	 	  println(IOUtils.toString(part.getInputStream))
	  }
	   	
  }
}