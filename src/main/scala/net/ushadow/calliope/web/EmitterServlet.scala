package net.ushadow.calliope.web

import javax.servlet.http._
import java.util.Date
import net.ushadow.calliope._
import com.google.appengine.api.datastore._
import com.google.appengine.api.labs.taskqueue._
import com.google.appengine.api.labs.taskqueue.TaskOptions.Builder._;

class EmitterServlet extends HttpServlet {

  private val emitter = new Emitter

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val event = new InMemoryEvent("e-mail", Map("from" -> "alexguev@gmail.com", "sentOn" -> new Date()))
    emitter.emit(event)

  }

}