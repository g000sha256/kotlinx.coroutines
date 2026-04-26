package kotlinx.coroutines.flow

import kotlinx.coroutines.testing.*
import kotlin.test.*

class FirstNullTest : TestBase() {

    @Test
    fun testFirstNull() = runTest {
        val flow = flowOf(1, 2, null, 3)

        val result = flow.firstNull()

        assertEquals(
            expected = Unit,
            actual = result,
        )
    }

    @Test
    fun testFirstNullOnAllNotNull() = runTest {
        val flow = flowOf(1, 2, 3)

        assertFailsWith<NoSuchElementException> { flow.firstNull() }
    }

    @Test
    fun testFirstNullOnEmpty() = runTest {
        val flow = emptyFlow<Int>()

        assertFailsWith<NoSuchElementException> { flow.firstNull() }
    }
}
