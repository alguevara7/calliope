package net.ushadow.calliope

import org.junit.runner.RunWith

import org.scalatest.Spec
import org.scalatest.mock.MockitoSugar
import org.scalatest.junit.JUnitRunner
import org.mockito._
import org.mockito.Mockito._

@RunWith(classOf[JUnitRunner])
class UShadowSpec extends Spec with MockitoSugar {
	
	describe("an u-shadow") {
		it("must allow all activities to process received events") {
			val activity1 = mock[Activity]
			val activity2 = mock[Activity]
			val ushadow = new UShadow(List(activity1, activity2))
			
			val event = new Object
			ushadow.receive(event)
			
			verify(activity1).process(event)
			verify(activity2).process(event)
		}
	}
	
	

}