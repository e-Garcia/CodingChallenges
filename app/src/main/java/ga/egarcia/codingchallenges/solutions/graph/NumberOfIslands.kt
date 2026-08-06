package ga.egarcia.codingchallenges.solutions.graph

/**
 * LeetCode 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n grid of '1' (land) and '0' (water), return the number of
 * islands. An island is formed by connecting adjacent land cells
 * horizontally or vertically (no diagonals).
 *
 * BFS flood-fill: scanning the grid, every unvisited land cell found is the
 * start of a new island. Flood-fill (BFS) from that cell marks every cell
 * reachable from it as visited, so the outer scan never counts it again.
 *
 * Time:  O(rows * cols) — visited is shared across every flood-fill call, so
 *        each cell is enqueued and processed at most once across the whole run.
 * Space: O(rows * cols) — visited array, plus the BFS queue in the worst case
 *        (e.g. a grid that's a single island).
 */
fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val numRows = grid.size
    val numCols = grid[0].size
    val visitedGrid = Array(numRows) { BooleanArray(numCols) }

    var numIslands = 0
    for (r in 0 until numRows) {
        for (c in 0 until numCols) {
            if (grid[r][c] == '1' && !visitedGrid[r][c]) {
                numIslands++
                floodFill(r, c, grid, visitedGrid)
            }
        }
    }

    return numIslands
}

private val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, 1), Pair(0, -1)) // up, down, right, left

private fun floodFill(startR: Int, startC: Int, grid: Array<CharArray>, visitedGrid: Array<BooleanArray>) {
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(Pair(startR, startC))
    visitedGrid[startR][startC] = true

    while (queue.isNotEmpty()) {
        val (row, column) = queue.removeFirst()

        directions.forEach { (dr, dc) ->
            val neighborRow = row + dr
            val neighborColumn = column + dc
            val isInBounds = neighborRow in grid.indices && neighborColumn in grid[0].indices

            if (isInBounds) {
                val isLand = grid[neighborRow][neighborColumn] == '1'
                val isVisited = visitedGrid[neighborRow][neighborColumn]

                if (isLand && !isVisited) {
                    visitedGrid[neighborRow][neighborColumn] = true
                    queue.add(Pair(neighborRow, neighborColumn))
                }
            }
        }
    }
}
