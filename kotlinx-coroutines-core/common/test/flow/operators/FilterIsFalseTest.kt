package kotlinx.coroutines.flow

import kotlinx.coroutines.testing.*
import kotlin.test.*

class FilterIsFalseTest : TestBase() {

    @Test
    fun testFilterIsFalse() = runTest {
        val flow = flowOf(true, false, true, false, true)

        val result = flow.filterIsFalse()

        assertEquals(
            expected = listOf(Unit, Unit),
            actual = result.toList(),
        )
    }

    @Test
    fun testFilterIsFalseOnAllTrue() = runTest {
        val flow = flowOf(true, true)

        val result = flow.filterIsFalse()

        assertEquals(
            expected = emptyList(),
            actual = result.toList(),
        )
    }

    @Test
    fun testFilterIsFalseOnEmpty() = runTest {
        val flow = emptyFlow<Boolean>()

        val result = flow.filterIsFalse()

        assertEquals(
            expected = emptyList(),
            actual = result.toList(),
        )
    }
}
