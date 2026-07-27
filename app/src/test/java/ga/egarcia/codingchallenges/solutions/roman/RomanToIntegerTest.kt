package ga.egarcia.codingchallenges.solutions.roman

import org.junit.Assert.*
import org.junit.Test

class RomanToIntegerTest {

    @Test
    fun singleSymbols() {
        assertEquals(1, romanToInt("I"))
        assertEquals(5, romanToInt("V"))
        assertEquals(10, romanToInt("X"))
        assertEquals(50, romanToInt("L"))
        assertEquals(100, romanToInt("C"))
        assertEquals(500, romanToInt("D"))
        assertEquals(1000, romanToInt("M"))
    }

    @Test
    fun simpleAdditiveCombinations() {
        assertEquals(2, romanToInt("II"))
        assertEquals(3, romanToInt("III"))
        assertEquals(7, romanToInt("VII"))
        assertEquals(27, romanToInt("XXVII"))
    }

    @Test
    fun subtractiveCombinations() {
        assertEquals(4, romanToInt("IV"))
        assertEquals(9, romanToInt("IX"))
        assertEquals(40, romanToInt("XL"))
        assertEquals(90, romanToInt("XC"))
        assertEquals(400, romanToInt("CD"))
        assertEquals(900, romanToInt("CM"))
    }

    @Test
    fun mixedAdditiveAndSubtractive() {
        assertEquals(58, romanToInt("LVIII"))     // L + V + III
        assertEquals(1994, romanToInt("MCMXCIV")) // M + CM + XC + IV
        assertEquals(1444, romanToInt("MCDXLIV")) // M + CD + XL + IV
        assertEquals(2024, romanToInt("MMXXIV"))
    }

    @Test
    fun boundaries() {
        assertEquals(1, romanToInt("I"))
        assertEquals(3999, romanToInt("MMMCMXCIX")) // largest value expressible
    }
}