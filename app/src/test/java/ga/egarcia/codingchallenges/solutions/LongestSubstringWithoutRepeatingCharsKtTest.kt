package ga.egarcia.codingchallenges.solutions

import junit.framework.TestCase.assertEquals
import org.junit.Test

class LongestSubstringWithoutRepeatingCharsKtTest {

    @Test
    fun `Empty String`() {
        // Given
        val input = ""
        val expectedOutput = 0
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `Empty String 2`() {
        // Given
        val input = " "
        val expectedOutput = 1
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with no repeating characters`() {
        val input = "abcde"
        val expectedOutput = 5
        val actual = lengthOfLongestSubstring(input)
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with all repeating characters`() {
        val input = "aaaaa"
        val expectedOutput = 1
        val actual = lengthOfLongestSubstring(input)
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with repeating characters at the beginning`() {
        // Test with a string like "aabcde". Expected output: 5 (abcde)
        val input = "aabcde"
        val expectedOutput = 5
        val actual = lengthOfLongestSubstring(input)
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with repeating characters at the end`() {
        // Given
        val input = "abcdee"
        val expectedOutput = 5 // "abcde"
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with repeating characters in the middle`() {
        // Given
        val input = "abccde"
        val expectedOutput = 3 // "abc" or "cde"
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with multiple longest substrings`() {
        // Given
        val input = "abcabcbb"
        val expectedOutput = 3 // "abc", "bca", or "cab"
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with a single character`() {
        // Given
        val input = "x"
        val expectedOutput = 1
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with two characters  same`() {
        // Given
        val input = "aa"
        val expectedOutput = 1
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with two characters  different`() {
        // Given
        val input = "ab"
        val expectedOutput = 2
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `Long string with no repeating characters`() {
        // Given
        val input = ('a'..'z').joinToString("") + ('A'..'Z').joinToString("") + ('0'..'9').joinToString("")
        val expectedOutput = input.length
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `Long string with many repeating characters`() {
        // Given
        val input = "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz" +
                "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz"
        val expectedOutput = 2 // Only two unique consecutive characters at most
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with special characters`() {
        // Given
        val input = "a b c 1 2 3 ! @ #"
        val expectedOutput = 3  // Longest substring without repeating characters
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `String with Unicode characters`() {
        // Given
        val input = "你好世界你好"
        val expectedOutput = 4 // "你好世界"
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `Substring at the very end of the string`() {
        // Given
        val input = "abcdeafg"
        val expectedOutput = 7 // "cdeafg"
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `Map behavior with previously seen character updating left pointer`() {
        // Given
        val input = "abba"
        val expectedOutput = 2 // "ab" or "ba"
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `Edge case for  lastCharSeenMap char     0 `() {
        // Given
        val input = "a"
        val expectedOutput = 1
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `Final substring check after loop`() {
        // Given
        val input = "abcdef"
        val expectedOutput = 6 // "abcdef"
        // When
        val actual = lengthOfLongestSubstring(input)
        // Then
        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `Test case 1`() {
        val input = "abcabcbb"
        val expectedOutput = 3
        val actual = lengthOfLongestSubstring(input)

        assertEquals(expectedOutput, actual)
    }


}