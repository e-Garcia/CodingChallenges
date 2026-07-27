package ga.egarcia.codingchallenges.solutions.patterns


/**
 * Example output for n = 7:
 * middle = 3
 *     *    -> 3( ) + 1 (*)
 *    ***   -> 2( ) + 3 (*)
 *   *****  -> 1( ) + 5 (*)
 *  ******* -> 0( ) + 7 (*)
 *   *****  -> 1( ) + 5 (*)
 *    ***   -> 2( ) + 3 (*)
 *     *    -> 3( ) + 1 (*)
 *  Prints a diamond pattern of asterisks with a given height.
 *  The diamond is centered, with leading spaces before the asterisks.
 *  The pattern is symmetric, with the upper part being the same as the lower part.
 *  @param n The height of the diamond, must be an even number.
 */
fun printDiamondPattern(n: Int) : String {

    val stringBuilder = StringBuilder()
    val leadingChar = ' '
    val contentChar = '*'

    // Upper part of the diamond
    val middle = n / 2

    for (rowIndex in 0 .. middle) {
        // Print leading spaces
        val leadingSpaces = middle - rowIndex
        for (columnIndex in 0 until leadingSpaces) {
            stringBuilder.append(leadingChar)
        }

        val contentLength = 2 * rowIndex + 1
        // Print content characters (asterisks)
        for (columnIndex in 0 until contentLength) {
            stringBuilder.append(contentChar)
        }

        // Move to the next line
        stringBuilder.appendLine()
    }

    // Lower part of the diamond

    for (rowIndex in (middle - 1) downTo  0) { /** 2 **/
        // Print leading spaces
        val leadingSpaces = middle - rowIndex
        for (columnIndex in 0 until leadingSpaces) { /** 1 **/
            stringBuilder.append(leadingChar)
        }

        val contentLength = (rowIndex * 2) + 1 /** 3 **/
        for (columnIndex in 0 until contentLength) { /** 5 **/
            stringBuilder.append(contentChar)
        }

        // Move to the next line
        stringBuilder.appendLine()

    }


    // Print asterisks
    print(stringBuilder.toString())
    return stringBuilder.toString()
}