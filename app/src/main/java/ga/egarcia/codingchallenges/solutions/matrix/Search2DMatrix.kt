package ga.egarcia.codingchallenges.solutions.matrix

/**
 * LeetCode 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Each row is sorted left to right, and the first integer of each row is
 * greater than the last integer of the previous row — so the whole matrix,
 * read row by row, is really one sorted array wearing a grid costume.
 * Return true if target exists anywhere in it, false otherwise, in
 * O(log(rows*cols)).
 *
 * Binary search over a "flattened" virtual 1D index:
 *   virtualIndex -> row = virtualIndex / numCols, col = virtualIndex % numCols
 *
 * Time:  O(log(rows*cols)) — standard binary search over rows*cols elements.
 * Space: O(1).
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false

    val numRows = matrix.size
    val numCols = matrix[0].size
    val totalCells = numRows * numCols

    var left = 0
    var right = totalCells - 1

    while (left <= right) {
        val mid = (left + right) / 2
        val row = mid / numCols
        val col = mid % numCols
        val midValue = matrix[row][col]

        when {
            midValue == target -> return true
            midValue < target -> left = mid + 1
            midValue > target -> right = mid - 1
        }
    }

    return false
}
