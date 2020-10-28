package contracts.tests

import core.calendars.CalendarService
import core.calendars.CalendarTestRepository
import financial.contracts.ContractHistoryService
import financial.contracts.ContractHistoryTestDataRepository
import financial.contracts.ContractService
import financial.contracts.ContractTestDataRepository
import physical.estates.EstateService
import physical.estates.EstateTestRepository
import physical.harvests.HarvestService
import physical.harvests.HarvestTestRepository

class ContractServiceTest {

    @Test
    fun givenEmptyRepository_whenContractsAreQueried_thenNothingIsFound() {
        val fakeContractHistoryService = ContractHistoryService(ContractHistoryTestDataRepository())
        val fakeCalendarService = CalendarService(CalendarTestRepository())
        val fakeEstateService = EstateService(EstateTestRepository())
        val fakeHarvestService = HarvestService(HarvestTestRepository())
        val given = ContractService(ContractTestDataRepository(), fakeContractHistoryService, fakeCalendarService, fakeEstateService, fakeHarvestService)
    }

    @Test
    fun givenNonEmptyRepository_whenContractsAreQueried_thenAllAreFound() {}

    @Test
    fun givenInvalidContractId_whenQueriedById_thenNothingIsFound() {}

    @Test
    fun givenValidContractId_whenQueriedById_thenCorrectContractIsFound() {}

    @Test
    fun givenValidContract_whenPostedByANonEstateOwner_thenRejectedBySystem() {}

    @Test
    fun givenValidContract_whenPostedByAnEstateOwner_thenAcceptedBySystem() {}

    @Test
    fun givenPostedContract_whenRescindedTriedByNonOwner_thenRejectedBySystem() {}

    @Test
    fun givenPostedContract_whenRescindedByEstateOwner_thenAcceptedBySystem() {}

    @Test
    fun givenPostedContract_whenExpirationDateExceeded_thenRejectedBySystem() {}

    @Test
    fun givenPostedContract_whenAcceptedByEstateOwner_thenRejectedBySystem() {}

    @Test
    fun givenPostedContract_whenAcceptedByAnotherUser_thenContractBecomesPending() {}

    // TODO: hard to think of use cases when dealing with Pending Contracts - just for accounting basically
    @Test
    fun givenPendingContract_whenSomethingHappens_thenDoWhat() {}
}