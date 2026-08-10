package ga.egarcia.codingchallenges.solutions.stack

import junit.framework.TestCase
import org.junit.Test

class DailyTemperaturesTest {

    @Test
    fun `Classic mixed example`() {
        val temps = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        val expected = intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)
        TestCase.assertEquals(expected.toList(), dailyTemperatures(temps).toList())
    }

    @Test
    fun `All increasing, each day waits exactly one`() {
        val temps = intArrayOf(70, 71, 72, 73)
        val expected = intArrayOf(1, 1, 1, 0)
        TestCase.assertEquals(expected.toList(), dailyTemperatures(temps).toList())
    }

    @Test
    fun `All decreasing, nobody ever finds a warmer day`() {
        val temps = intArrayOf(73, 72, 71, 70)
        val expected = intArrayOf(0, 0, 0, 0)
        TestCase.assertEquals(expected.toList(), dailyTemperatures(temps).toList())
    }

    @Test
    fun `All equal temperatures, equal does not count as warmer`() {
        val temps = intArrayOf(70, 70, 70)
        val expected = intArrayOf(0, 0, 0)
        TestCase.assertEquals(expected.toList(), dailyTemperatures(temps).toList())
    }

    @Test
    fun `Single day`() {
        val temps = intArrayOf(70)
        val expected = intArrayOf(0)
        TestCase.assertEquals(expected.toList(), dailyTemperatures(temps).toList())
    }

    @Test
    fun `Empty input`() {
        val temps = intArrayOf()
        val expected = intArrayOf()
        TestCase.assertEquals(expected.toList(), dailyTemperatures(temps).toList())
    }
}
