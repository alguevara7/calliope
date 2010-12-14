package net.ushadow.calliope.web

import net.ushadow.calliope.InMemoryEvent
import net.ushadow.calliope.Emitter
import org.slf4j.LoggerFactory
import ch.qos.logback.classic.Logger
import org.apache.commons.io.IOUtils
import javax.mail.Multipart
import javax.mail.internet.MimeMessage
import javax.mail.Session
import java.util.Properties
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServlet

class MailHandlerServlet extends HttpServlet {

  private val logger = LoggerFactory.getLogger("MailHandlerServlet")
  
  private val emitter = new Emitter

  override def doPost(req: HttpServletRequest, resp: HttpServletResponse) = {
    val props = new Properties
    val session = Session.getDefaultInstance(props, null)
    val message = new MimeMessage(session, req.getInputStream)
    
    emitter.emit(new InMemoryEvent(
    		"e-mail", 
    		Map("sentOn"->message.getSentDate, "from"->message.getFrom.toString)))
  }
  
  private def logContent(message: MimeMessage) {
    val content = message.getContent
    if (content.isInstanceOf[Multipart]) {
      val _content = content.asInstanceOf[Multipart]
      for (i <- 0 to _content.getCount - 1) {
        val part = _content.getBodyPart(i)
        logger.info(IOUtils.toString(part.getInputStream))
      }
    } else {
      logger.info(content.asInstanceOf[String])
    }
  }
}