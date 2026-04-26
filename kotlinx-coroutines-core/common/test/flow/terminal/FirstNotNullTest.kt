package kotlinx.coroutines.flow

import kotlinx.coroutines.testing.*
import kotlin.test.*

class FirstNotNullTest : TestBase() {

    @Test
    fun testFirstNotNull() = runTest {
        val flow = flowOf(null, 1, 2, null, 3)

        val result = flow.firstNotNull()

        assertEquals(
            expected = 1,
            actual = result,
        )
    }

    @Test
    fun testFirstNotNullOnAllNull() = runTest {
        val flow = flowOf(null, null, null)

        assertFailsWith<NoSuchElementException> { flow.firstNotNull() }
    }

    @Test
    fun testFirstNotNullOnEmpty() = runTest {
        val flow = emptyFlow<Int>()

        assertFailsWith<NoSuchElementException> { flow.firstNotNull() }
    }
}
