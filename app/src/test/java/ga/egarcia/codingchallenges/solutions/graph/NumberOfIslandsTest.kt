package ga.egarcia.codingchallenges.solutions.graph

import junit.framework.TestCase
import org.junit.Test

class NumberOfIslandsTest {

    @Test
    fun `Single island`() {
        val grid = arrayOf(
            "11110".toCharArray(),
            "11010".toCharArray(),
            "11000".toCharArray(),
            "00000".toCharArray()
        )
        TestCase.assertEquals(1, numIslands(grid))
    }

    @Test
    fun `Three islands`() {
        val grid = arrayOf(
            "11000".toCharArray(),
            "11000".toCharArray(),
            "00100".toCharArray(),
            "00011".toCharArray()
        )
        TestCase.assertEquals(3, numIslands(grid))
    }

    @Test
    fun `All water`() {
        val grid = arrayOf(
            "0000".toCharArray(),
            "0000".toCharArray()
        )
        TestCase.assertEquals(0, numIslands(grid))
    }

    @Test
    fun `All land is one island`() {
        val grid = arrayOf(
            "111".toCharArray(),
            "111".toCharArray(),
            "111".toCharArray()
        )
        TestCase.assertEquals(1, numIslands(grid))
    }

    @Test
    fun `Single cell island`() {
        val grid = arrayOf(
            "1".toCharArray()
        )
        TestCase.assertEquals(1, numIslands(grid))
    }

    @Test
    fun `Diagonal cells are not connected`() {
        val grid = arrayOf(
            "10".toCharArray(),
            "01".toCharArray()
        )
        TestCase.assertEquals(2, numIslands(grid))
    }
}
