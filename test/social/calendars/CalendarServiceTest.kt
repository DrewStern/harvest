package test.social.calendars

import social.calendars.CalendarService
import social.calendars.CalendarTestRepository
import social.calendars.DateRange
import java.util.*
import kotlin.test.assertEquals

class CalendarServiceTest {
    @Test
    fun givenDateRange_whenCheckingIfEarlierDateIsContained_thenFalse() {
        val calendarService = CalendarService(CalendarTestRepository())
        val range = buildDateRangeContainingAllOf2020()
        val date = Date(1000, 11, 25)
        val expected = false
        val actual = calendarService.isContainedInRange(date, range)
        assertEquals(expected, actual)
    }

    @Test
    fun givenDateRange_whenCheckingIfLaterDateIsContained_thenFalse() {
        val calendarService = CalendarService(CalendarTestRepository())
        val range = buildDateRangeContainingAllOf2020()
        val date = Date(4000, 11, 25)
        val expected = false
        val actual = calendarService.isContainedInRange(date, range)
        assertEquals(expected, actual)
    }

    @Test
    fun givenDateRange_whenCheckingIfItsMidpointIsContained_thenTrue() {
        val calendarService = CalendarService(CalendarTestRepository())
        val range = buildDateRangeContainingAllOf2020()
        val date = Date(2020, 11, 25)
        val expected = true
        val actual = calendarService.isContainedInRange(date, range)
        assertEquals(expected, actual)
    }

    @Test
    fun givenDateRange_whenAnotherDateRangeExtendsToEarlierDate_thenFalse() {}

    @Test
    fun givenDateRange_whenAnotherDateRangeExtendsToLaterDate_thenFalse() {}

    @Test
    fun givenDateRange_whenAnotherDateRangeIsStrictlyContained_thenTrue() {}

    private fun buildDateRangeContainingAllOf2020(): DateRange {
        val start = Date(2020, 0, 0)
        val end = Date(2020, 11, 31)
        return DateRange(start, end)
    }
}