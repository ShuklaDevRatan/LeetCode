class Solution {

    public boolean predictTheWinner(int[] nums) {

        return solve(nums, 0, nums.length - 1) >= 0;
    }

    private int solve(int[] nums, int left, int right) {

        if (left == right)
            return nums[left];

        int takeLeft = nums[left] - solve(nums, left + 1, right);

        int takeRight = nums[right] - solve(nums, left, right - 1);

        return Math.max(takeLeft, takeRight);
    }
}