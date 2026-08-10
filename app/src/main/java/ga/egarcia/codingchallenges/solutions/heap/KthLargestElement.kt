package ga.egarcia.codingchallenges.solutions.heap

import java.util.PriorityQueue

/**
 * LeetCode 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Return the kth largest element in sorted order (not the kth distinct
 * value; duplicates each count as their own position).
 *
 * [3,2,1,5,6,4], k=2 -> 5
 * [3,2,3,1,2,4,5,5,6], k=4 -> 4
 *
 * Min-heap capped at size k: push every number, and whenever the heap
 * grows past k, pop the smallest. What's left is the k largest numbers
 * seen, and the heap's root is the smallest of that set, i.e. the kth
 * largest overall.
 *
 * Time O(n log k), space O(k).
 */
fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>()

    nums.forEach() { num ->
        minHeap.add(num)
        if (minHeap.size > k) {
            minHeap.remove()
        }
    }

    return minHeap.peek() ?: 0
}
