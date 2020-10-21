package contracts.tests

import contracts.*

class ContractServiceTest {
    @Before

    @Test
    fun givenNothing_whenContractsAreQueried_thenAllAreFound() {
        val expected = ContractServiceTestDataFactory.getBasicTestData()
        val actual = fakeContract
    }
}