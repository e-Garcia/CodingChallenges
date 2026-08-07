package ga.egarcia.codingchallenges.solutions.graph

import junit.framework.TestCase
import org.junit.Test

class RottingOrangesTest {

    @Test
    fun `Rot spreads to all fresh oranges`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1)
        )
        TestCase.assertEquals(4, orangesRotting(grid))
    }

    @Test
    fun `Unreachable fresh orange returns -1`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1)
        )
        TestCase.assertEquals(-1, orangesRotting(grid))
    }

    @Test
    fun `No fresh oranges at all returns 0`() {
        val grid = arrayOf(
            intArrayOf(0, 2)
        )
        TestCase.assertEquals(0, orangesRotting(grid))
    }

    @Test
    fun `All empty grid returns 0`() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        TestCase.assertEquals(0, orangesRotting(grid))
    }

    @Test
    fun `Fresh orange with no rotten source returns -1`() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        TestCase.assertEquals(-1, orangesRotting(grid))
    }

    @Test
    fun `Single rotten cell only`() {
        val grid = arrayOf(
            intArrayOf(2)
        )
        TestCase.assertEquals(0, orangesRotting(grid))
    }

    @Test
    fun `Two separate rot sources spreading simultaneously`() {
        // minute 1: (0,0)->(1,0), (0,4)->(1,4)
        // minute 2: (1,0)->(1,1), (1,4)->(1,3)
        // minute 3: (1,1)->(1,2)  [(1,3) also reaches for (1,2) same minute, already rotting]
        val grid = arrayOf(
            intArrayOf(2, 0, 0, 0, 2),
            intArrayOf(1, 1, 1, 1, 1)
        )
        TestCase.assertEquals(3, orangesRotting(grid))
    }
}
