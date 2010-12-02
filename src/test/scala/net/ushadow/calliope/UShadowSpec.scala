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

    it("should apply the actions resulting from processing activities") {
      val world = new World

      val activity1 = mock[Activity]
      val activity2 = mock[Activity]
      val ushadow = new UShadow(world, List(activity1, activity2))

      val event = new FakeEvent()

      val action1 = mock[Action]
      when(activity1.process(event)).thenReturn(Some(action1))

      val action2 = mock[Action]
      when(activity2.process(event)).thenReturn(Some(action2))

      ushadow.receive(event)

      verify(action1).apply(world)
      verify(action2).apply(world)
    }

    it("should not fail when processing an activity returns None") {
      val world = new World

      val activity = mock[Activity]
      val ushadow = new UShadow(null, List(activity))

      val event = new FakeEvent()

      val action = mock[Action]
      when(activity.process(event)).thenReturn(None)

      ushadow.receive(event)
    }

  }

  class FakeEvent extends Event {
    def kind = "fake"
	def properties = Map()     	
  }
}