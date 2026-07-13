class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
                binarySearch(nums, target, true),   // First Occurrence
                binarySearch(nums, target, false)   // Last Occurrence
        };
    }

    private int binarySearch(int[] nums, int target, boolean findFirst) {

        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {

                ans = mid;

                if (findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}