package ga.egarcia.codingchallenges.solutions.slidingwindow

/**
 * LeetCode 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Given a string s and an integer k, you may replace up to k characters in
 * s with any other uppercase letter. Return the length of the longest
 * substring you can make consist of a single repeated character.
 *
 * s = "ABAB", k = 2    -> 4  (replace both A's, or both B's -> "BBBB"/"AAAA")
 * s = "AABABBA", k = 1 -> 4  ("AABA" -> replace the one B -> "AAAA")
 *
 * Variable-size sliding window, same shape as Longest Substring Without
 * Repeating Characters, but the "is this window still valid?" check is
 * different: instead of "no duplicate chars", it's "the number of chars
 * that AREN'T the window's most-frequent char is <= k" (those are the ones
 * you'd need to replace).
 *
 * Time:  O(n) — see the WHY THIS WORKS note below the function.
 * Space: O(1) — frequency map bounded by the fixed uppercase alphabet (26).
 */
fun characterReplacement(s: String, k: Int): Int {
    val freqMap = mutableMapOf<Char, Int>()

    var left = 0
    var maxLength = 0

    // Monotonic high-water mark: the largest repeat-count of any single
    // character seen in ANY window scanned so far — NOT necessarily the
    // true max in the CURRENT window (after a shrink, it can be stale/too
    // high). Never decremented, by design. See WHY THIS WORKS below.
    var bestRepeatStreakSeenSoFar = 0

    for (right in s.indices) {
        val char = s[right]
        freqMap[char] = freqMap.getOrDefault(char, 0) + 1
        bestRepeatStreakSeenSoFar = maxOf(bestRepeatStreakSeenSoFar, freqMap.getOrDefault(char, 0))

        fun windowSize() = right - left + 1
        // Not "the true number of replacements this exact window needs" —
        // it's "how many replacements we'd need IF this window matched our
        // best streak so far." That framing is what makes the staleness
        // safe: we're bounding growth against a historical fact, not
        // re-verifying the current window every time.
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

// WHY THIS WORKS despite bestRepeatStreakSeenSoFar being stale/inaccurate
// for the CURRENT window after a shrink:
//
// 1. windowSize (right - left + 1) is monotonically NON-DECREASING across
//    the entire run — it only ever stays the same or grows by exactly 1
//    per step, NEVER drops below a value it already reached. Why: each
//    step adds exactly 1 to windowSize (right advances by 1), and
//    bestRepeatStreakSeenSoFar can only stay the same or grow by 1 too —
//    so the "invalid" check can only be violated by exactly 1 unit, and
//    exactly one shrink always restores validity.
//
// 2. Because windowSize never decreases, its value at the END of the
//    string is automatically its MAXIMUM across the whole run — maxLength
//    just tracks the final windowSize, nothing more.
//
// 3. Any time windowSize grows PAST its previous record, that growth only
//    happens because bestRepeatStreakSeenSoFar was JUST freshly raised to
//    an accurate value (freq[s[right]], not stale) in that same step — so
//    every new record is genuinely, accurately earned at the moment it's
//    set. Staleness only ever creeps in AFTER a record is already locked
//    in, which can only make the window coast at its current size instead
//    of shrinking further — it can never inflate maxLength beyond a size
//    that was truly, accurately proven achievable.
//
// Verified empirically too: see `Stale version agrees with TrueMax version
// across many random inputs` in the test file — 2000 random strings, zero
// disagreements between this version and characterReplacementTrueMax()
// below, which recomputes the true max from scratch on every single check.

// Comparison version — same algorithm, but with ZERO cleverness: no
// high-water-mark tracking at all. Every time "the most frequent character's
// count in the current window" is needed, it's recomputed from scratch by
// scanning freqMap.values(). Costs a larger constant factor (bounded by the
// 26-letter alphabet) but is still O(n) overall — kept here as a reference
// for why the stale-tracking version above is provably equivalent, not just
// usually right.
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

// Option 2 reference (not wired into characterReplacement() above — this is
// the "if this were production code" version, for future reuse).
//
// Instead of just documenting "never decrement this variable" and trusting
// every future reader/editor to honor that rule, encode the invariant in
// the TYPE: give it no setter and no decrement method, only a way to record
// a new value if it's higher. Then "accidentally lowering it" becomes a
// compile error instead of a subtle bug someone introduces under deadline
// pressure six months from now.
//
// Usage would look like:
//   val bestRepeatStreakSeenSoFar = HighWaterMark()
//   ...
//   bestRepeatStreakSeenSoFar.recordIfHigher(freqMap.getOrDefault(char, 0))
//   ...
//   fun charsNeededIfWeMatchOurBestStreak() =
//       windowSize() - bestRepeatStreakSeenSoFar.value
class HighWaterMark {
    var value: Int = 0
        private set

    fun recordIfHigher(candidate: Int) {
        if (candidate > value) value = candidate
    }
}
