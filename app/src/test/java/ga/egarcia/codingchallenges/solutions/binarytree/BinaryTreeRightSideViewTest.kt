package ga.egarcia.codingchallenges.solutions.binarytree

import org.junit.Test
import kotlin.test.assertEquals

class BinaryTreeRightSideViewTest {

    @Test
    fun `rightSideView   Empty Tree`() {
        // Test with an empty tree (root is null). Expect an empty list.
        // Given
        val input = null
        val expected = emptyList<Int>()
        // When
        val actual = rightSideView(input)
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   Single Node Tree`() {
        // Test with a tree containing only the root node. Expect a list with the root's value.
        // Given
        val input = TreeNode(1)
        val expected = listOf(1)
        // When
        val actual = rightSideView(input)
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   Left Skewed Tree`() {
        // Test with a tree where all nodes are left children. Expect a list containing all nodes in order from root to leaf.
        // Given
        val input = TreeNode(1, TreeNode(2, TreeNode(3)))
        val expected = listOf(1, 2, 3)
        // When
        val actual = rightSideView(input)
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   Right Skewed Tree`() {
        // Test with a tree where all nodes are right children. Expect a list containing all nodes in order from root to leaf.
        // Given
        val input = TreeNode(1, null, TreeNode(2, null, TreeNode(3)))
        val expected = listOf(1, 2, 3)
        // When
        val actual = rightSideView(input)
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   Complete Binary Tree`() {
        // Test with a complete binary tree. Expect a list of the rightmost nodes at each level.
        // Given
        //      1
        //     / \
        //    2   3
        //   / \ / \
        //  4  5 6  7
        val input = TreeNode(
            1,
            TreeNode(2, TreeNode(4), TreeNode(5)),
            TreeNode(3, TreeNode(6), TreeNode(7))
        )
        val expected = listOf(1, 3, 7)
        // When
        val actual = rightSideView(input)
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   General Case   Right nodes present at all levels`() {
        // Test with a general binary tree where right children exist at each level that has a rightmost node. 
        // Example: [1,2,3,null,5,null,4]. Expected: [1,3,4]
        //      1
        //     / \
        //    2   3
        //     \    \
        //      5    4
        val input = TreeNode(
            1,
            TreeNode(2, null, TreeNode(5)),
            TreeNode(3, null, TreeNode(4))
        )
        val expected = listOf(1, 3, 4)
        val actual = rightSideView(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   General Case   Left nodes become rightmost`() {
        // Test with a general binary tree where some left children become the rightmost node at their level. 
        // Example: [1,2,3,4,null,null,null,5]. Expected: [1,3,4,5]
        //        1
        //      /   \
        //     2     3
        //    /
        //   4
        //  /
        // 5
        val input = TreeNode(
            1,
            TreeNode(2, TreeNode(4, TreeNode(5))),
            TreeNode(3)
        )
        val expected = listOf(1, 3, 4, 5)
        val actual = rightSideView(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   Tree with Gaps  null children `() {
        // Test with a tree that has null children interspersed, ensuring correct traversal. 
        // Example from prompt: [1,2,3,4,7,null,null,5]. Expected: [1,3,7,5]
        //         1
        //       /   \
        //      2     3
        //     / \
        //    4   7
        //   /
        //  5
        val input = TreeNode(
            1,
            TreeNode(2, TreeNode(4, TreeNode(5)), TreeNode(7)),
            TreeNode(3)
        )
        val expected = listOf(1, 3, 7, 5)
        val actual = rightSideView(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   Deep Tree`() {
        // Test with a very deep tree to check for potential stack overflow issues due to recursion.
        // Given: left-skewed tree 1->2->3->...->20
        var node: TreeNode? = null
        for (i in 20 downTo 1) {
            node = TreeNode(i, node)
        }
        val expected = (1..20).toList()
        val actual = rightSideView(node)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   Tree with Negative Values`() {
        // Test with a tree containing negative node values.
        //      -1
        //     /  \
        //   -2   -3
        val input = TreeNode(-1, TreeNode(-2), TreeNode(-3))
        val expected = listOf(-1, -3)
        val actual = rightSideView(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightSideView   Tree with Duplicate Values`() {
        // Test with a tree containing duplicate node values, ensure the logic picks the structurally rightmost.
        //      1
        //     / \
        //    1   1
        //   /
        //  1
        val input = TreeNode(1, TreeNode(1, TreeNode(1)), TreeNode(1))
        val expected = listOf(1, 1, 1)
        val actual = rightSideView(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Both Lists Empty`() {
        // Test when both leftList and rightList are empty. Expect an empty list.
        val left = emptyList<Int>()
        val right = emptyList<Int>()
        val expected = emptyList<Int>()
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Left List Empty  Right List Non Empty`() {
        // Test when leftList is empty and rightList has elements. Expect a list identical to rightList.
        val left = emptyList<Int>()
        val right = listOf(10, 20, 30)
        val expected = listOf(10, 20, 30)
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Right List Empty  Left List Non Empty`() {
        // Test when rightList is empty and leftList has elements. Expect a list identical to leftList.
        val left = listOf(1, 2, 3)
        val right = emptyList<Int>()
        val expected = listOf(1, 2, 3)
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Left List Shorter than Right List`() {
        // Test when leftList has fewer elements than rightList. Expect elements from rightList to take precedence, followed by remaining leftList elements. 
        // Example: left=[1,2], right=[10,20,30]. Expected: [10,20,30]
        val left = listOf(1, 2)
        val right = listOf(10, 20, 30)
        val expected = listOf(10, 20, 30)
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Right List Shorter than Left List`() {
        // Test when rightList has fewer elements than leftList. Expect elements from rightList to take precedence, followed by remaining leftList elements. 
        // Example: left=[1,2,3], right=[10,20]. Expected: [10,20,3]
        val left = listOf(1, 2, 3)
        val right = listOf(10, 20)
        val expected = listOf(10, 20, 3)
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Lists of Equal Length`() {
        // Test when both lists have the same number of elements. Expect all elements from rightList. 
        // Example: left=[1,2,3], right=[10,20,30]. Expected: [10,20,30]
        val left = listOf(1, 2, 3)
        val right = listOf(10, 20, 30)
        val expected = listOf(10, 20, 30)
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Lists with Negative Values`() {
        // Test with lists containing negative values to ensure they are handled correctly.
        val left = listOf(-1, -2, -3)
        val right = listOf(-10, -20)
        val expected = listOf(-10, -20, -3)
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Lists with Duplicate Values`() {
        // Test with lists containing duplicate values, ensuring the merging logic is correct based on list origin (right preferred).
        val left = listOf(1, 2, 2)
        val right = listOf(2, 2, 3)
        val expected = listOf(2, 2, 3)
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

    @Test
    fun `rightMergeLists   Large Lists`() {
        // Test with very large lists to check for performance and memory usage.
        val left = (1..1000).toList()
        val right = (1001..2000).toList()
        val expected = (1001..2000).toList()
        val actual = rightMergeLists(left, right)
        assertEquals(expected, actual)
    }

}