class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;
        
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid - 1;
            } else {
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
                subarrays++;
                currentSum = num;
            }
        }

        return subarrays <= k;
    }
}