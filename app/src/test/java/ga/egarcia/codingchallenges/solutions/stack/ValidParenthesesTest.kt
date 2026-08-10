package ga.egarcia.codingchallenges.solutions.stack

import junit.framework.TestCase
import org.junit.Test

class ValidParenthesesTest {

    @Test
    fun `Simple valid pairs`() {
        TestCase.assertEquals(true, isValid("()[]{}"))
    }

    @Test
    fun `Mismatched bracket types`() {
        TestCase.assertEquals(false, isValid("(]"))
    }

    @Test
    fun `Wrong order despite matching types`() {
        TestCase.assertEquals(false, isValid("([)]"))
    }

    @Test
    fun `Properly nested`() {
        TestCase.assertEquals(true, isValid("{[]}"))
    }

    @Test
    fun `Empty string is valid`() {
        TestCase.assertEquals(true, isValid(""))
    }

    @Test
    fun `Single opening bracket is invalid`() {
        TestCase.assertEquals(false, isValid("("))
    }

    @Test
    fun `Single closing bracket is invalid`() {
        TestCase.assertEquals(false, isValid(")"))
    }

    @Test
    fun `Closing bracket with empty stack`() {
        TestCase.assertEquals(false, isValid("]"))
    }

    @Test
    fun `Deeply nested valid`() {
        TestCase.assertEquals(true, isValid("({[]})"))
    }

    @Test
    fun `Extra unmatched opening bracket at the end`() {
        TestCase.assertEquals(false, isValid("()["))
    }
}
