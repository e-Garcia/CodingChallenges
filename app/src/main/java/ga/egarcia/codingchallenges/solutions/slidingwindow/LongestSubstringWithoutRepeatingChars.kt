package ga.egarcia.codingchallenges.solutions.slidingwindow

// Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/

/**
 * Problem:
 * Given a string, find the length of the longest substring without repeating characters.
 * Sliding window solution with O(n) time complexity.
 */
fun lengthOfLongestSubstring(s: String): Int {
    var largestSubstringLength = 0
    val lastCharSeenMap = mutableMapOf<Char, Int>()
    var left = 0

    for (i in s.indices) {
        val char = s[i]
        println("c:$char l:$left r:$i lcs:$lastCharSeenMap")

        if (lastCharSeenMap.containsKey(char)) {
            val lastCharSeenIndex = lastCharSeenMap[char]!!
            left = maxOf(left, lastCharSeenIndex + 1)
        }

        largestSubstringLength = maxOf(largestSubstringLength, i - left + 1)
        lastCharSeenMap[char] = i
    }

    return largestSubstringLength
}

/**
 * Kotlin syntax shortcuts for map operations:
 *
 * Java:    map.put(key, map.getOrDefault(key, 0) + 1)
 * Kotlin:  map[key] = map.getOrDefault(key, 0) + 1   ← bracket syntax
 * Kotlin:  map.compute(key) { _, v -> (v ?: 0) + 1 }   ← no double lookup
 *
 * For your code, replace:
 *   seenCharMap.put(value, seenCharMap.getOrDefault(value, 0) + 1)
 * With:
 *   seenCharMap[value] = seenCharMap.getOrDefault(value, 0) + 1
 */
