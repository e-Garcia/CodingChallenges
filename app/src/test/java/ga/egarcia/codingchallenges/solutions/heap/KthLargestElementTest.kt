package ga.egarcia.codingchallenges.solutions.heap

import junit.framework.TestCase
import org.junit.Test

class KthLargestElementTest {

    @Test
    fun `Classic example, no duplicates`() {
        TestCase.assertEquals(5, findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    }

    @Test
    fun `Classic example with duplicates`() {
        TestCase.assertEquals(4, findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    @Test
    fun `Single element array`() {
        TestCase.assertEquals(1, findKthLargest(intArrayOf(1), 1))
    }

    @Test
    fun `k=1 returns the maximum`() {
        TestCase.assertEquals(5, findKthLargest(intArrayOf(1, 5, 3, 2, 4), 1))
    }

    @Test
    fun `k=array size returns the minimum`() {
        TestCase.assertEquals(1, findKthLargest(intArrayOf(1, 5, 3, 2, 4), 5))
    }

    @Test
    fun `All identical elements`() {
        TestCase.assertEquals(4, findKthLargest(intArrayOf(4, 4, 4, 4), 2))
    }

    @Test
    fun `Negative numbers`() {
        TestCase.assertEquals(-2, findKthLargest(intArrayOf(-1, -2, -3, -4), 2))
    }
}
