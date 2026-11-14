class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        // Step 1: Create Prefix Sum Array
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int minSum = Integer.MAX_VALUE;

        // Step 2: Generate all possible subarrays
        for (int i = 0; i < n; i++) {

            for (int len = l; len <= r; len++) {

                int j = i + len;

                if (j > n) {
                    break;
                }

                // Step 3: Calculate subarray sum
                int sum = prefix[j] - prefix[i];

                // Step 4: Check positive minimum sum
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}