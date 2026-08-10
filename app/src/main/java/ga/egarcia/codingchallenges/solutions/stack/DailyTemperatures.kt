package ga.egarcia.codingchallenges.solutions.stack

/**
 * LeetCode 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Given daily temperatures, return an array where answer[i] is the number
 * of days until a warmer temperature. If none exists, answer[i] = 0.
 *
 * [73,74,75,71,69,72,76,73] -> [1,1,4,2,1,1,0,0]
 *
 * Monotonic stack of indices, kept in decreasing temperature order from
 * bottom to top. On each day, pop and resolve every index whose day has
 * now found something warmer, then push the current index.
 *
 * Time O(n): each index is pushed and popped at most once.
 * Space O(n): stack plus the result array.
 */
fun dailyTemperatures(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack = ArrayDeque<Int>()

    temperatures.forEachIndexed() { index, temp ->
        while (stack.isEmpty().not() && temp > temperatures[stack.last()]) {
            val prevTempIndex = stack.removeLast()
            result[prevTempIndex] = index - prevTempIndex
        }
        stack.add(index)
    }

    return result
}
