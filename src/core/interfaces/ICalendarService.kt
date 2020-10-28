package core.interfaces

import core.calendars.DateRange
import java.util.*

interface ICalendarService {
    fun isOrderedCorrectly(range: DateRange): Boolean
    fun isContainedInRange(point: Date, range: DateRange): Boolean
    fun isStrictlyContainedInRange(smaller: DateRange, larger: DateRange): Boolean
    fun isBeforeRange(date: Date, range: DateRange): Boolean
    fun isAfterRange(date: Date, range: DateRange): Boolean
}