package ga.egarcia.codingchallenges.solutions.slidingwindow

// Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/

/**
 * Problem:
 * Given a string, find the length of the longest substring without repeating characters.
 * Sliding window solution with O(n) time complexity.
 */
fun lengthOfLongestSubstring(s: String): Int {
    var longestLength = 0
    val lastCharSeenMap = mutableMapOf<Char, Int>()
    var left = 0

    for (i in s.indices) {
        val char = s[i]

        lastCharSeenMap[char]?.let { lastCharSeenIndex ->
            left = maxOf(left, lastCharSeenIndex + 1)
        }

        longestLength = maxOf(longestLength, i - left + 1)
        lastCharSeenMap[char] = i
    }

    return longestLength
}
