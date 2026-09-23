package ga.egarcia.codingchallenges.solutions.patterns

/**
 * Prints a diamond pattern of asterisks with a given height.
 *
 * The diamond is centered with leading spaces before the asterisks and is symmetric
 * between the upper and lower parts. The pattern always produces an odd number of rows
 * equal to `n + 1` when `n` is odd.
 *
 * Example output for n = 7:
 * ```
 *     *
 *    ***
 *   *****
 *  *******
 *   *****
 *    ***
 *     *
 * ```
 *
 * @param n The height of the diamond (number of rows in the upper half minus one).
 *          Must be a positive odd number.
 * @throws IllegalArgumentException if n is not positive or is even.
 */
fun printDiamondPattern(n: Int): String {
    require(n > 0 && n % 2 != 0) { "n must be a positive odd number" }

    val middle = n / 2
    val rows = mutableListOf<String>()

    // Upper part of the diamond (including middle row)
    for (rowIndex in 0..middle) {
        rows.add(buildRow(n, rowIndex))
    }

    // Lower part of the diamond (exclude middle row)
    for (rowIndex in (middle - 1) downTo 0) {
        rows.add(buildRow(n, rowIndex))
    }

    return rows.joinToString("\n")
}

private fun buildRow(n: Int, rowIndex: Int): String {
    val leadingChar = ' '
    val contentChar = '*'
    val leadingSpaces = middle - rowIndex
    val contentLength = 2 * rowIndex + 1

    return " ".repeat(leadingSpaces) + contentChar.repeat(contentLength)
}
