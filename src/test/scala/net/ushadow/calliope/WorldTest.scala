package net.ushadow.calliope

import com.google.appengine.tools.development.testing.LocalURLFetchServiceTestConfig
import com.google.appengine.tools.development.testing.LocalServiceTestHelper
object WorldTest {
	
  def main(args: Array[String]) {
    val helper = new LocalServiceTestHelper(new LocalURLFetchServiceTestConfig());
    helper.setUp
    try {
    	new World().sendProwlNotification("lala lalala lalal", "alexguev@gmail.com")
    } finally {
    	helper.tearDown
    }
  }

}