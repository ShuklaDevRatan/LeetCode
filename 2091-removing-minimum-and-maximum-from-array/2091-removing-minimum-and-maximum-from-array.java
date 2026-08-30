class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find min and max indices
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // 4 possible ways
        int bothFront = Math.max(minIndex, maxIndex) + 1;
        int bothBack = n - Math.min(minIndex, maxIndex);
        int minFrontMaxBack = (minIndex + 1) + (n - maxIndex);
        int maxFrontMinBack = (maxIndex + 1) + (n - minIndex);

        return Math.min(
            Math.min(bothFront, bothBack),
            Math.min(minFrontMaxBack, maxFrontMinBack)
        );
    }
}