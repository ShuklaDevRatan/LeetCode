class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length-1;
        int prod1 = nums[i] * nums[++i] * nums[n];
        int prod2 = nums[n]*nums[n-1]*nums[n-2];
        return Math.max(prod1 , prod2);
    }
}