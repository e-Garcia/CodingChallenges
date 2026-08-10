package ga.egarcia.codingchallenges.solutions.slidingwindow

import junit.framework.TestCase
import org.junit.Test
import kotlin.random.Random

class LongestRepeatingCharacterReplacementTest {

    @Test
    fun `Replace both of the minority character`() {
        TestCase.assertEquals(4, characterReplacement("ABAB", 2))
    }

    @Test
    fun `Replace a single character in the middle`() {
        TestCase.assertEquals(4, characterReplacement("AABABBA", 1))
    }

    @Test
    fun `Already all the same character`() {
        TestCase.assertEquals(4, characterReplacement("AAAA", 0))
    }

    @Test
    fun `No replacements allowed, all distinct characters`() {
        TestCase.assertEquals(2, characterReplacement("ABCDE", 1))
    }

    @Test
    fun `Single character string`() {
        TestCase.assertEquals(1, characterReplacement("A", 0))
    }

    @Test
    fun `No replacements allowed, longest existing run wins`() {
        TestCase.assertEquals(3, characterReplacement("AAAB", 0))
    }

    // Same exact cases, run against the no-stale-tracking comparison version.
    // If these pass with identical expected values, that's empirical proof
    // the stale-max trick in characterReplacement() doesn't change the answer.

    @Test
    fun `TrueMax - Replace both of the minority character`() {
        TestCase.assertEquals(4, characterReplacementTrueMax("ABAB", 2))
    }

    @Test
    fun `TrueMax - Replace a single character in the middle`() {
        TestCase.assertEquals(4, characterReplacementTrueMax("AABABBA", 1))
    }

    @Test
    fun `TrueMax - Already all the same character`() {
        TestCase.assertEquals(4, characterReplacementTrueMax("AAAA", 0))
    }

    @Test
    fun `TrueMax - No replacements allowed, all distinct characters`() {
        TestCase.assertEquals(2, characterReplacementTrueMax("ABCDE", 1))
    }

    @Test
    fun `TrueMax - Single character string`() {
        TestCase.assertEquals(1, characterReplacementTrueMax("A", 0))
    }

    @Test
    fun `TrueMax - No replacements allowed, longest existing run wins`() {
        TestCase.assertEquals(3, characterReplacementTrueMax("AAAB", 0))
    }

    // Randomized cross-check: the stale-max version and the always-recompute
    // version should agree on EVERY input, not just the hand-picked cases
    // above. Small alphabet (A-D) so repeats/collisions are common — a huge
    // random alphabet would make every string look like "all distinct chars",
    // which isn't an interesting test of the shrink logic.
    @Test
    fun `Stale version agrees with TrueMax version across many random inputs`() {
        val random = Random(seed = 42) // fixed seed: reproducible if it ever fails
        val alphabet = "ABCD"

        repeat(2000) { iteration ->
            val length = random.nextInt(0, 41) // 0..40 chars
            val s = (1..length).map { alphabet[random.nextInt(alphabet.length)] }.joinToString("")
            val k = random.nextInt(0, length + 1) // 0..length

            val staleResult = characterReplacement(s, k)
            val trueMaxResult = characterReplacementTrueMax(s, k)

            TestCase.assertEquals(
                "Mismatch on iteration $iteration: s=\"$s\", k=$k",
                trueMaxResult,
                staleResult
            )
        }
    }
}
