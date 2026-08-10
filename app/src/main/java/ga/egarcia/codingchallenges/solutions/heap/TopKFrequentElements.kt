package ga.egarcia.codingchallenges.solutions.heap

import java.util.PriorityQueue

/**
 * LeetCode 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array and k, return the k most frequent elements. Any
 * order is fine.
 *
 * [1,1,1,2,2,3], k=2 -> [1,2]  (1 appears 3x, 2 appears 2x, 3 appears 1x)
 * [1], k=1 -> [1]
 *
 * Same min-heap-of-size-k trick as findKthLargest, one layer up: count
 * frequencies first, then run the heap trick over (number, frequency)
 * entries ordered by frequency instead of raw numbers.
 *
 * Time O(n log k), space O(n) for the frequency map.
 */
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val frequencies = hashMapOf<Int, Int>() // <Number, Frequency>
    for (num in nums) {
        frequencies[num] = frequencies.getOrDefault(num, 0) + 1
    }

    val topK = PriorityQueue<Map.Entry<Int, Int>>(compareBy {it.value})

    for(entry in frequencies.entries) {
        topK.offer(entry)
        if (topK.size > k) {
            topK.poll()
        }
    }

    return topK.map { it.key }.toIntArray()
}
