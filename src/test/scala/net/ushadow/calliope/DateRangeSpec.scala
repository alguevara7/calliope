package net.ushadow.calliope

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import java.util.Date
import org.scalatest.Spec

@RunWith(classOf[JUnitRunner])
class DateRangeSpec extends Spec {

	describe("date range encompasing a full 24h day") {

		it("tbd") {
			val today = DateRange.day(new Date)
			today.belongs(new Date)
			
			fail("tbd")
		}

	}
	
}