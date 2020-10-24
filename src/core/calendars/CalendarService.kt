package core.calendars

import core.interfaces.IRepository
import core.interfaces.ICalendarService
import java.util.*

class CalendarService: ICalendarService {
    private val repository: IRepository<Calendar>

    constructor(repository: IRepository<Calendar>) {
        this.repository = repository
    }

    override fun isContainedInRange(point: Date, range: DateRange): Boolean {
        return range.start.before(point) && range.end.after(point)
    }

    override fun isStrictlyContainedInRange(smaller: DateRange, larger: DateRange): Boolean {
        return isContainedInRange(smaller.start, larger) && isContainedInRange(smaller.end, larger)
    }
}
