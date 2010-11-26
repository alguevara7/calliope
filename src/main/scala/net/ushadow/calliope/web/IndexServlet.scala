package net.ushadow.calliope.web

import javax.servlet.http._

class IndexServlet extends HttpServlet {

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) =
    resp.getWriter().print("<HTML>" +
      "<HEAD><TITLE>Hello, Scala!</TITLE></HEAD>" +
      "<BODY>Hello, Scala! This is a servlet.</BODY>" +
      "</HTML>")
}