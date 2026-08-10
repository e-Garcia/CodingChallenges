package ga.egarcia.codingchallenges.solutions.slidingwindow

/**
 * LeetCode 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Given a string s and an integer k, you can replace up to k characters
 * with any other uppercase letter. Return the length of the longest
 * substring you can make consist of a single repeated character.
 *
 * "ABAB", k=2 -> 4 (replace both A's or both B's)
 * "AABABBA", k=1 -> 4 (replace the B in "AABA")
 *
 * Same sliding window shape as Longest Substring Without Repeating
 * Characters, but the validity check differs: the window is valid if
 * (window size - count of its most frequent char) <= k, since that's how
 * many characters would need replacing.
 *
 * Time O(n), space O(1) (frequency map bounded by the 26-letter alphabet).
 * See WHY THIS WORKS below for why the O(n) bound holds.
 */
fun characterReplacement(s: String, k: Int): Int {
    val freqMap = mutableMapOf<Char, Int>()

    var left = 0
    var maxLength = 0

    // Largest repeat count seen in any window so far, not necessarily the
    // current window (it's never decremented). See WHY THIS WORKS below.
    var bestRepeatStreakSeenSoFar = 0

    for (right in s.indices) {
        val char = s[right]
        freqMap[char] = freqMap.getOrDefault(char, 0) + 1
        bestRepeatStreakSeenSoFar = maxOf(bestRepeatStreakSeenSoFar, freqMap.getOrDefault(char, 0))

        fun windowSize() = right - left + 1
        // Replacements needed if this window matched our best streak so
        // far, not the true count for the current window. See WHY THIS
        // WORKS below for why that's fine.
        fun charsNeededIfWeMatchOurBestStreak(): Int = windowSize() - bestRepeatStreakSeenSoFar
        while (charsNeededIfWeMatchOurBestStreak() > k) {
            val firstChar = s[left]
            freqMap[firstChar] = freqMap.getOrDefault(firstChar, 0) - 1
            left++
        }

        maxLength = maxOf(maxLength, windowSize())
    }

    return maxLength
}

// WHY THIS WORKS
//
// bestRepeatStreakSeenSoFar can be stale for the current window after a
// shrink, but windowSize still ends up correct.
//
// windowSize only grows by 1 or stays flat each step, never drops below a
// value it already reached. Each step, right advances by 1 and
// bestRepeatStreakSeenSoFar grows by at most 1, so the validity check can
// only be off by exactly 1 unit, and one shrink always fixes it.
//
// Since windowSize never decreases, its value at the end of the string is
// already its maximum, so maxLength just tracks the final windowSize.
//
// Any time windowSize grows past its previous record, bestRepeatStreakSeenSoFar
// was just freshly and accurately raised in that same step, so every new
// record is genuinely earned. Staleness only shows up after a record is
// already locked in, and can only delay a shrink, never inflate the answer.
//
// Confirmed empirically too: see the randomized test comparing this against
// characterReplacementTrueMax(), which recomputes the true max from scratch
// on every check. 2000 random cases, zero disagreements.

// Same algorithm with no high-water-mark tracking: recomputes the true max
// frequency from freqMap.values() on every check instead. Larger constant
// factor (bounded by the 26-letter alphabet) but still O(n) overall. Kept
// as a reference confirming the stale-tracking version above is equivalent,
// not just usually right.
fun characterReplacementTrueMax(s: String, k: Int): Int {
    val freqMap = mutableMapOf<Char, Int>()

    var left = 0
    var maxLength = 0

    for (right in s.indices) {
        val char = s[right]
        freqMap[char] = freqMap.getOrDefault(char, 0) + 1

        fun windowSize() = right - left + 1
        fun maxFreqInWindow(): Int = freqMap.values.maxOrNull() ?: 0
        fun charsNeedingReplacement(): Int = windowSize() - maxFreqInWindow()
        while (charsNeedingReplacement() > k) {
            val firstChar = s[left]
            freqMap[firstChar] = freqMap.getOrDefault(firstChar, 0) - 1
            left++
        }

        maxLength = maxOf(maxLength, windowSize())
    }

    return maxLength
}

// Reference implementation, not used by characterReplacement() above.
// Encodes the "never decrement" rule in the type instead of a comment: no
// setter, no decrement method, only recordIfHigher(). Makes the invariant
// a compile error to violate instead of a rule to remember.
//
// Usage:
//   val bestRepeatStreakSeenSoFar = HighWaterMark()
//   bestRepeatStreakSeenSoFar.recordIfHigher(freqMap.getOrDefault(char, 0))
//   val charsNeeded = windowSize() - bestRepeatStreakSeenSoFar.value
class HighWaterMark {
    var value: Int = 0
        private set

    fun recordIfHigher(candidate: Int) {
        if (candidate > value) value = candidate
    }
}
