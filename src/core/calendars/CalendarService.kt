package core.calendars

import core.interfaces.IRepository
import core.interfaces.ICalendarService
import java.util.*

class CalendarService: ICalendarService {
    private val repository: IRepository<Calendar>

    constructor(repository: IRepository<Calendar>) {
        this.repository = repository
    }

    override fun isOrderedCorrectly(range: DateRange): Boolean {
        return range.start.before(range.end)
    }

    override fun isContainedInRange(date: Date, range: DateRange): Boolean {
        return range.start.before(date) && range.end.after(date)
    }

    override fun isStrictlyContainedInRange(smaller: DateRange, larger: DateRange): Boolean {
        return isContainedInRange(smaller.start, larger) && isContainedInRange(smaller.end, larger)
    }

    override fun isBeforeRange(date: Date, range: DateRange): Boolean {
        return isOrderedCorrectly(range) && date.before(range.start)
    }

    override fun isAfterRange(date: Date, range: DateRange): Boolean {
        return isOrderedCorrectly(range) && date.after(range.end)
    }
}
