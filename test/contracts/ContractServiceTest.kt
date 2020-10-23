package contracts.tests

import contracts.Contract
import kotlin.test.Test
import kotlin.test.assertEquals

class ContractServiceTest {

    @Test
    fun givenEmptyRepository_whenContractsAreQueried_thenNothingIsFound() {}

    @Test
    fun givenNonEmptyRepository_whenContractsAreQueried_thenAllAreFound() {}

    @Test
    fun givenInvalidContractId_whenQueriedById_thenNothingIsFound() {}

    @Test
    fun givenValidContractId_whenQueriedById_thenCorrectContractIsFound() {}

    @Test
    fun givenValidContract_whenPostedByANonEstateOwner_thenRejectedBySystem() {}

    @Test
    fun givenValidContract_whenPostedByAnEstateOwner_thenSuccessful() {}

    @Test
    fun givenPostedContract_whenRescindedTriedByNonOwner_thenFails() {}

    @Test
    fun givenPostedContract_whenRescindedByEstateOwner_thenSuccessful() {}

    @Test
    fun givenPostedContract_whenExpires_thenRejectedBySystem() {}

    @Test
    fun givenPostedContract_whenAcceptedByEstateOwner_thenRejectedBySystem() {}

    @Test
    fun givenPostedContract_whenAcceptedByAnotherUser_thenSuccessful() {}

    @Test
    fun givenAcceptedContract_when
}