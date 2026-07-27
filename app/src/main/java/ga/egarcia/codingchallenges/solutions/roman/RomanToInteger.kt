package ga.egarcia.codingchallenges.solutions.roman

/**
 * LeetCode 13. Roman to Integer
 *
 * Roman numerals are represented by seven symbols:
 *   I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 *
 * Numbers are formed by combining symbols and adding the values, e.g.
 * II = 2, XXVII = 27. Symbols are usually written largest to smallest,
 * left to right.
 *
 * Six combinations use SUBTRACTION instead of addition:
 *   IV = 4  (1 before 5)
 *   IX = 9  (1 before 10)
 *   XL = 40 (10 before 50)
 *   XC = 90 (10 before 100)
 *   CD = 400 (100 before 500)
 *   CM = 900 (100 before 1000)
 *
 * Given a roman numeral, convert it to an integer.
 *
 * Constraints:
 *  - 1 <= s.length <= 15
 *  - s contains only ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 *  - It is guaranteed that s is a valid roman numeral in the range [1, 3999]
 *
 * Examples:
 *  "III"      -> 3
 *  "LVIII"    -> 58    (L = 50, V = 5, III = 3)
 *  "MCMXCIV"  -> 1994  (M = 1000, CM = 900, XC = 90, IV = 4)
 */
fun romanToInt(s: String): Int {
    var result = 0
    s.forEachIndexed { i, current ->
        val currentNumber = numberMap[current] ?: 0
        val hasNext = i + 1 < s.length
        val nextNumber = if (hasNext) numberMap[s[i+1]] ?: 0 else 0

        if (currentNumber < nextNumber) {
            // IV, IX, XL, XC, CD, CM
            result -= currentNumber
        } else {
            // III, VI
            result += currentNumber
        }
    }

    return result
}

val numberMap = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)