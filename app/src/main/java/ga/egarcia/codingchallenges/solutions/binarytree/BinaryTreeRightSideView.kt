package ga.egarcia.codingchallenges.solutions.binarytree

/**
 * Problem: 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given the root of a binary tree, imagine standing on the right side of it.
 * Return the values of the nodes you can see ordered from top to bottom.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 100].
 * - The value of each node is between [-100, 100].
 */
fun rightSideView(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    root?.let { node ->
        result.add(node.`val`)
        val leftList = rightSideView(node.left)
        val rightList = rightSideView(node.right)
        result.addAll(rightMergeLists(leftList, rightList))
    }

    return result
}

fun rightMergeLists(leftList: List<Int>, rightList: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    val maxLength = maxOf(leftList.size, rightList.size)

    for (i in 0 until maxLength) {
        if (i < rightList.size) {
            result.add(rightList[i])
        } else if (i < leftList.size) {
            result.add(leftList[i])
        }
    }

    return result
}

class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

/**
 Approach:
              root[1,2,3,4,7,null,null,5]
                  1
          2              3
      4       7    null    null
 5

 Start by creating a list that includes the current node’s value
 [2]                       +                   [3]

 Recursively compute the right side view of the left and right children
 [4,5]     from 2’s children     +            []     from 3’s children

 Merge the two child arrays:
 Take values from the right array when present; otherwise, use values from the left
 [4, 5] + [7] -> [7, 5]

 Node 2 returns -> [2, 7, 5]
 Node 3 returns -> [3]

 Merge at root level:
 Combine [2, 7, 5] from left and [3] from right, using the same merge logic
 Final result: [1, 3, 7, 5]
**/



