package net.ushadow.calliope

import java.util.Date
import org.joda.time.DateTime

import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar

@RunWith(classOf[JUnitRunner])
class EMailDataExtractorSpec extends Spec with MockitoSugar {

  describe("an e-mail extractor") {

    val now = new Date()

    it("should extract 'sentOn' property") {
      val extractor = new EMailDataExtractor() {
        val event = new FakeEvent(Map("sentOn" -> now))
      }
      assert(extractor.sentOn === Some(new DateTime(now)))
    }

    it("should extract 'from' property") {
      val extractor = new EMailDataExtractor() {
        val event = new FakeEvent(Map("from" -> "araminta@u-shadow.net"))
      }
      assert(extractor.from === Some("araminta@u-shadow.net"))
    }

  }

  class FakeEvent(val nameValues: Map[String, Object]) extends Event {
    def kind = "fake"
    def properties = nameValues
  }

}

