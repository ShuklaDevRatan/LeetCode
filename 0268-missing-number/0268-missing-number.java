class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        long expectedSum = (long) n * (n + 1) / 2;

        long actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }
}