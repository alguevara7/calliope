package net.ushadow.calliope

import com.google.appengine.api.datastore.Entity
import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.mockito.Matchers._
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar

@RunWith(classOf[JUnitRunner])
class EventThatIsStorableSpec extends Spec with MockitoSugar {

  describe("a event that is storable") {

    it("should delegate to entity") {
    	//can not mock final classes, get Event to delegate to a type with
    	//the methods kind, hasProperty, getProperty
//    	val entity = mock[Entity]
//    	
//    	val event = new EventThatIsStorable(entity)
//    	
//    	when(entity.hasProperty("name")).thenReturn(true)
//    	when(entity.getProperty("name")).thenReturn("value", null)
//    	
//    	assert(event("name") == Some("value"))
    }

  }

}