package ga.egarcia.codingchallenges.solutions

// Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/

/**
 * Problem:
 * Given a string, find the length of the longest substring without repeating characters.
 * Sliding window solution with O(n) time complexity.
 */
fun lengthOfLongestSubstring(s: String): Int {
    var largestSubstringLength = 0

    // Tracks the last seen index of each character in the string
    // Key: character, Value: index where it was last seen
    val lastCharSeenMap = mutableMapOf<Char, Int>()
    var left = 0  // Start index of the current non-repeating window

    // Iterate through each character by index
    for (i in s.indices) {
        val char = s[i]
        val right = i

        // Debug: current character, window bounds, and state of the map
        println("c:$char l:$left r:$right lcs:$lastCharSeenMap")

        if (lastCharSeenMap.contains(char)) {
            // Character has been seen before — may need to shrink the window
            val lastCharSeenIndex = lastCharSeenMap[char] ?: 0
            // Move 'left' only forward to avoid including the repeated character
            left = maxOf(left, lastCharSeenIndex + 1)
        }

        // Calculate the length of the current non-repeating window
        val currentSubstringLength = right - left + 1
        largestSubstringLength = maxOf(currentSubstringLength, largestSubstringLength)

        // Update the map with the current character's latest index
        lastCharSeenMap[char] = right
    }

    return largestSubstringLength
}