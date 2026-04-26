package kotlinx.coroutines.flow

import kotlinx.coroutines.testing.*
import kotlin.test.*

class FilterIsTrueTest : TestBase() {

    @Test
    fun testFilterIsTrue() = runTest {
        val flow = flowOf(true, false, true, false, true)

        val result = flow.filterIsTrue()

        assertEquals(
            expected = listOf(Unit, Unit, Unit),
            actual = result.toList(),
        )
    }

    @Test
    fun testFilterIsTrueOnAllFalse() = runTest {
        val flow = flowOf(false, false)

        val result = flow.filterIsTrue()

        assertEquals(
            expected = emptyList(),
            actual = result.toList(),
        )
    }

    @Test
    fun testFilterIsTrueOnEmpty() = runTest {
        val flow = emptyFlow<Boolean>()

        val result = flow.filterIsTrue()

        assertEquals(
            expected = emptyList(),
            actual = result.toList(),
        )
    }
}
