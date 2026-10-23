class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int smaller = 0;
        int equal = 0;

        // Step 1: Count smaller and equal elements
        for (int num : nums) {
            if (num < pivot) {
                smaller++;
            } else if (num == pivot) {
                equal++;
            }
        }

        // Step 2: Initialize pointers
        int left = 0;
        int mid = smaller;
        int right = smaller + equal;

        int[] ans = new int[n];

        // Step 3: Place elements in their correct positions
        for (int num : nums) {
            if (num < pivot) {
                ans[left] = num;
                left++;
            } else if (num == pivot) {
                ans[mid] = num;
                mid++;
            } else {
                ans[right] = num;
                right++;
            }
        }

        return ans;
    }
}

