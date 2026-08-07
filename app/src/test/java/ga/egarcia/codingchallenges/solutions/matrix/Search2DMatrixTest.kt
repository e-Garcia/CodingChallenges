package ga.egarcia.codingchallenges.solutions.matrix

import junit.framework.TestCase
import org.junit.Test

class Search2DMatrixTest {

    private val matrix = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )

    @Test
    fun `Target present in the middle row`() {
        TestCase.assertEquals(true, searchMatrix(matrix, 16))
    }

    @Test
    fun `Target absent between two values`() {
        TestCase.assertEquals(false, searchMatrix(matrix, 13))
    }

    @Test
    fun `Target is the first element`() {
        TestCase.assertEquals(true, searchMatrix(matrix, 1))
    }

    @Test
    fun `Target is the last element`() {
        TestCase.assertEquals(true, searchMatrix(matrix, 60))
    }

    @Test
    fun `Target smaller than everything`() {
        TestCase.assertEquals(false, searchMatrix(matrix, 0))
    }

    @Test
    fun `Target larger than everything`() {
        TestCase.assertEquals(false, searchMatrix(matrix, 100))
    }

    @Test
    fun `Target at row boundary`() {
        // 10 is the first element of row 1 -- easy off-by-one spot for the flatten math
        TestCase.assertEquals(true, searchMatrix(matrix, 10))
    }

    @Test
    fun `Single row matrix`() {
        val singleRow = arrayOf(intArrayOf(1, 3, 5))
        TestCase.assertEquals(true, searchMatrix(singleRow, 3))
        TestCase.assertEquals(false, searchMatrix(singleRow, 4))
    }

    @Test
    fun `Single cell matrix`() {
        val singleCell = arrayOf(intArrayOf(5))
        TestCase.assertEquals(true, searchMatrix(singleCell, 5))
        TestCase.assertEquals(false, searchMatrix(singleCell, 6))
    }

    @Test
    fun `Empty matrix returns false`() {
        val empty = arrayOf<IntArray>()
        TestCase.assertEquals(false, searchMatrix(empty, 1))
    }
}
