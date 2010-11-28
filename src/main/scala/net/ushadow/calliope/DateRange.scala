package net.ushadow.calliope

import java.util.Date

class DateRange(start: Date, end: Date) {
	
	def belongs(date: Date): Boolean = {
		(start == date || start.before(date)) && (end == date || end.after(date)) 
	}

}

object DateRange {
	def day(date: Date) = new DateRange(new Date, new Date)
}