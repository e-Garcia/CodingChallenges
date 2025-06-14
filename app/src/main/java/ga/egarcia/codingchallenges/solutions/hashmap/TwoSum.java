package ga.egarcia.codingchallenges.solutions.hashmap;

import java.util.HashMap;

class TwoSum {
    /**
     * Problem: {@link <a href="https://leetcode.com/problems/two-sum/">...</a>}

     Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:

     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     **/
    public static final int[] PAIR_NOT_FOUND = new int[0];
    
    /**
    * Returns the indices of two numbers whose sum matches the given target.
    * The same element cannot be used twice.
    * Ex: sums [9, -1, 1, 12] target 0 ; result in [1,2]
    * a + b = target; a - target = b
    * Time:
    *   Best: O(N)
    *   Worst: O(N²)
    *   Current: O(N)
    * Space:
    *   O(N)
    **/
    public static int[] twoSum(int[] nums, int target) {
        
        // Input data validations
        if(nums == null || nums.length == 0) {
            return PAIR_NOT_FOUND; // Invalid input
        }
        
        // Find two numbers whose sum is target
        return findPairHashMap(nums, target);

    }
    
    /**
    * Function that finds the index number of the number that added to firstNumber equals 
    * the given target number
    * Time:
    *   O(N²)
    * Space:
    *   O(1)
    **/
    @SuppressWarnings("unused") // kept for educational comparison
    private int[] findPairBruteForce(final int[] numbers, final int target) {
        
        // Search for a matching pair
        for(int firstNumberIndex = 0; firstNumberIndex < numbers.length; firstNumberIndex++) {
            final int firstNumber = numbers[firstNumberIndex];
            
            for(int secondNumberIndex = 0; secondNumberIndex < numbers.length; secondNumberIndex++) {

                final int secondNumber = numbers[secondNumberIndex];

                if(firstNumber + secondNumber == target) {
                    return new int[] {firstNumberIndex, secondNumberIndex};
                }
            }
        }
        
        // No matching pair was found
        return PAIR_NOT_FOUND;
    }
    
    /**
    * Function that finds the index number of the number in the given group that added to firstNumber equals 
    * the given target number
    * Time:
    *   O(N)
    * Space:
    *   O(N)
    **/
    private static int[] findPairHashMap(final int[] numbers, final int target) {
        
        // Create a hashmap(K,V) where the number is the key and the value is its index
        final HashMap<Integer, Integer> numbersMap = new HashMap<>();
        
        for(int index = 0; index < numbers.length; index++) {
            final int number = numbers[index];
            numbersMap.put(number, index);
        }
        
        // Traverse numbers and look for the missing pair on the map
        for(int firstNumberIndex = 0; firstNumberIndex < numbers.length; firstNumberIndex++) {
            final int matchingPair = target - numbers[firstNumberIndex]; // firstNumber + b = target; b = target - firstNumber;  
            final Integer secondNumberIndex = numbersMap.get(matchingPair);
            
            if(secondNumberIndex != null && secondNumberIndex != firstNumberIndex) {
                return new int[] {firstNumberIndex, secondNumberIndex};
            }
        }
        return PAIR_NOT_FOUND;
    }
    
}
