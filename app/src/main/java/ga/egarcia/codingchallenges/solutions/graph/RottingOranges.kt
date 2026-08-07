package ga.egarcia.codingchallenges.solutions.graph

/**
 * LeetCode 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 *
 * grid values: 0 = empty, 1 = fresh orange, 2 = rotten orange. Every minute,
 * any fresh orange 4-directionally adjacent to a rotten orange becomes
 * rotten. Return the minimum minutes until no cell has a fresh orange, or
 * -1 if some fresh orange can never rot.
 *
 * Multi-source BFS: seed the queue with every rotten orange at minute 0
 * (not just one), then expand outward one full BFS level at a time — each
 * level processed corresponds to exactly one minute. Rotting a cell in
 * place doubles as the "visited" marker, since a rotten cell is never
 * re-enqueued.
 *
 * Time:  O(rows * cols) — each fresh cell is enqueued at most once.
 * Space: O(rows * cols) — BFS queue worst case (e.g. a wide simultaneous
 *        wavefront).
 */

private val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, 1), Pair(0, -1)) // top, down, right, left

enum class OrangeState(val value: Int) {
    EMPTY(0), FRESH(1), ROTTEN(2)
}

fun orangesRotting(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val numRows = grid.size
    val numCols = grid[0].size
    val queue = ArrayDeque<Pair<Int, Int>>()

    var freshCount = 0
    for (r in 0 until numRows) {
        for(c in 0 until numCols) {
            when (grid[r][c]) {
                OrangeState.EMPTY.value -> {} // empty, ignore
                OrangeState.FRESH.value -> { freshCount++}
                OrangeState.ROTTEN.value -> { queue.add(Pair(r, c)) } // rotten, add to queue
            }
        }
    }

    var minutes = 0
    while (queue.isEmpty().not() && freshCount > 0) {
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val (r, c) = queue.removeFirst()
            for ((dr, dc) in directions) {
                val neighborRow = r + dr
                val neighborCol = c + dc
                val isInBounds = neighborRow in grid.indices && neighborCol in grid[0].indices

                if (isInBounds) {
                    val neighborValue = grid[neighborRow][neighborCol]
                    if (neighborValue == OrangeState.FRESH.value) {
                        grid[neighborRow][neighborCol] = OrangeState.ROTTEN.value
                        freshCount--
                        queue.add(Pair(neighborRow, neighborCol))
                    }
                }
            }
        }
        minutes++
    }

    return if (freshCount > 0) -1 else minutes
}
