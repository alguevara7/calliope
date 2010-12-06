package net.ushadow.calliope.web

import javax.servlet.http._
import java.util.Date
import net.ushadow.calliope._
import net.ushadow.calliope.collector._
import com.google.appengine.api.datastore._
import com.google.appengine.api.labs.taskqueue._
import com.google.appengine.api.labs.taskqueue.TaskOptions.Builder._;

class EmitterServlet extends HttpServlet {

  private val emitter = new Emitter
  private val eventCollectors = List(new IntelliwareEMailEventCollector("guevaraa", "#1engine3"))

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
	  for (collector <- eventCollectors; event <- collector.collect) {
	 	  emitter.emit(event)
	  }
  }

}