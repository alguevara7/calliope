package net.ushadow.calliope

import java.net.URLEncoder
import org.apache.commons.lang.StringEscapeUtils
import org.slf4j.LoggerFactory
import java.io.ByteArrayInputStream
import com.google.appengine.tools.development.testing.LocalURLFetchServiceTestConfig
import com.google.appengine.tools.development.testing.LocalServiceTestHelper
import com.google.appengine.api.urlfetch._
import com.google.appengine.api.urlfetch.FetchOptions.Builder._
import java.net.URL
import scala.xml.XML

//FIXME: remove World, create ActionExecutor (saves action as event blah)
//FIXME: an action could be self contained or it could delegate
//FIXME: instead of World, we might want Platform
//FIXEM: actually World should only be accessible to Actions
class World {

  private val fetchService = URLFetchServiceFactory.getURLFetchService

  def sendProwlNotification(subject: String, message: String) = {
    val request = new HTTPRequest(
    		new URL("https://prowl.weks.net/publicapi/add?" +
    			Map("apikey" -> "3b6f6ae0c1f98f10ee38307ca39bb9b6d3561d0e",
    				"application" -> "u-shadow",
    				"event" -> URLEncoder.encode(subject),
    				"description" -> URLEncoder.encode(message)).map{case (k, v) => k+"="+v}.reduceRight(_ + "&" + _)), 
    		HTTPMethod.PUT, doNotFollowRedirects())

    val response = fetchService.fetch(request)
    logInfo("response: " + response.getResponseCode)
    val content = XML.load(new ByteArrayInputStream(response.getContent));
    logInfo("\n" + content)
  }

  private def logInfo(message: String) = LoggerFactory.getLogger(getClass()).info(message)
  
}