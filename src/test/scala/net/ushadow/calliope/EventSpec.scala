package net.ushadow.calliope

import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar

@RunWith(classOf[JUnitRunner])
class EventSpec extends Spec with MockitoSugar {

  describe("an event") {

    it("should delegate apply to hasProperty/getProperty") {
      val event = new Event {
        def kind = "fake"
        def properties = Map("name" -> "value")
      }

      assert(event.kind == "fake")
      assert(event("name") == Some("value"))
      assert(event("other") == None)
      
    }

  }

}