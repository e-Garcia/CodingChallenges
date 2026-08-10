package ga.egarcia.codingchallenges.solutions.stack

/**
 * LeetCode 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing only '(', ')', '{', '}', '[', ']', determine if
 * it's valid: every opening bracket must be closed by the same type of
 * bracket, in the correct order.
 *
 * "()[]{}" -> true
 * "(]"     -> false (mismatched types)
 * "([)]"   -> false (wrong order)
 * "{[]}"   -> true
 *
 * Push opening brackets onto a stack. On a closing bracket, pop and check
 * it matches. Valid only if the stack ends up empty.
 *
 * Time O(n), space O(n).
 */
fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val matchingBrackets = mapOf(')' to '(', '}' to '{', ']' to '[')
    val isOpening = setOf('(', '{', '[')
    val isClosing = setOf(')', '}', ']')

    s.forEach() { bracket ->
        when (bracket) {
            in isOpening -> stack.add(bracket)
            in isClosing -> {
                val previousBracket = stack.removeLastOrNull() ?: return false
                if (previousBracket != matchingBrackets[bracket]) {
                    return false
                }
            }
        }
    }

    return stack.isEmpty()
}
