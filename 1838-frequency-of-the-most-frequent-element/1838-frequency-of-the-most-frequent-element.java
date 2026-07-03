class Solution {
    public int maxFrequency(int[] nums, int k) {

        // Step 1: Sort the array.
        // Reason:
        // - We can only INCREMENT elements.
        // - So, for any window, the target will always be the largest
        //   element (rightmost element after sorting).
        Arrays.sort(nums);

        int left = 0;          // Left pointer of the sliding window.
        long windowSum = 0;    // Sum of all elements inside the current window.
        int maxFreq = 0;       // Stores the maximum valid window size.

        // Expand the window by moving the right pointer.
        for (int right = 0; right < nums.length; right++) {

            // Include the new element in the window.
            windowSum += nums[right];

            /*
             * Cost Formula:
             *
             * Operations Required =
             * (Target * Window Size) - Window Sum
             *
             * Target = nums[right]
             *
             * Example:
             * Window = [2, 4, 7]
             *
             * We want to make every element equal to 7.
             *
             * (7-2) + (7-4) + (7-7)
             * = 5 + 3 + 0
             * = 8
             *
             * Formula:
             * (7 * 3) - (2+4+7)
             * = 21 - 13
             * = 8
             */

            // If required operations exceed k,
            // shrink the window from the left.
            while ((long) nums[right] * (right - left + 1) - windowSum > k) {

                // Remove the leftmost element from the window.
                windowSum -= nums[left];

                // Shrink the window.
                left++;
            }

            // Current window is valid.
            // Window size represents the frequency we can achieve.
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}