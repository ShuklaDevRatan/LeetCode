class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                k--;
            }

            while (k < 0) {
                if (nums[left] % 2 != 0) {
                    k++;
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
