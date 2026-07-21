class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // Search Space -> [max element, total sum]
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {

            // Candidate answer
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                // Possible -> Try smaller answer
                high = mid - 1;
            } else {
                // Not possible -> Increase answer
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxAllowedSum) {

        int currentSum = 0;
        int subarrays = 1;

        for (int num : nums) {

            if (currentSum + num <= maxAllowedSum) {
                currentSum += num;
            } else {
                // Start a new subarray
                subarrays++;
                currentSum = num;
            }
        }

        // Greedy creates minimum subarrays needed
        return subarrays <= k;
    }
}