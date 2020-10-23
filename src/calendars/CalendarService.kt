package calendars

import java.util.*

class CalendarService: ICalendarService {
    fun isContainedInRange(point: Date, range: DateRange): Boolean {
        return range.start.before(point) && range.end.after(point)
    }

    fun isStrictlyContainedInRange(smaller: DateRange, larger: DateRange): Boolean {
        return isContainedInRange(smaller.start, larger) && isContainedInRange(smaller.end, larger)
    }
}
