package ga.egarcia.codingchallenges.solutions.heap

import junit.framework.TestCase
import org.junit.Test

class TopKFrequentElementsTest {

    @Test
    fun `Classic example`() {
        val result = topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
        TestCase.assertEquals(setOf(1, 2), result.toSet())
    }

    @Test
    fun `Single element`() {
        val result = topKFrequent(intArrayOf(1), 1)
        TestCase.assertEquals(setOf(1), result.toSet())
    }

    @Test
    fun `Clear frequency winner`() {
        val result = topKFrequent(intArrayOf(4, 4, 4, 4, 5, 5, 6), 1)
        TestCase.assertEquals(setOf(4), result.toSet())
    }

    @Test
    fun `Top two with a clear cutoff`() {
        val result = topKFrequent(intArrayOf(7, 7, 8, 8, 8, 9), 2)
        TestCase.assertEquals(setOf(8, 7), result.toSet())
    }

    @Test
    fun `k equals number of distinct elements, returns everything`() {
        val result = topKFrequent(intArrayOf(1, 2, 3), 3)
        TestCase.assertEquals(setOf(1, 2, 3), result.toSet())
    }

    @Test
    fun `Negative numbers`() {
        val result = topKFrequent(intArrayOf(-1, -1, -2, -3), 1)
        TestCase.assertEquals(setOf(-1), result.toSet())
    }

    @Test
    fun `Result size matches k`() {
        val result = topKFrequent(intArrayOf(1, 1, 2, 2, 2, 3, 4, 4, 4, 4), 2)
        TestCase.assertEquals(2, result.size)
        TestCase.assertEquals(setOf(4, 2), result.toSet())
    }
}
