package core.interfaces

import core.calendars.DateRange
import java.util.*

interface ICalendarService {
    fun isContainedInRange(point: Date, range: DateRange): Boolean
    fun isStrictlyContainedInRange(smaller: DateRange, larger: DateRange): Boolean
}