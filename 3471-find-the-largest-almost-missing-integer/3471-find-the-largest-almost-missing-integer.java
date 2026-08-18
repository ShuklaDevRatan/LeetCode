class Solution {
    public int largestInteger(int[] nums, int k) {

        int[] windowCount = new int[51];

        for (int start = 0; start <= nums.length - k; start++) {

            boolean[] seen = new boolean[51];

            for (int i = start; i < start + k; i++) {

                int x = nums[i];

                if (!seen[x]) {
                    windowCount[x]++;
                    seen[x] = true;
                }
            }
        }

        int ans = -1;

        for (int x = 0; x <= 50; x++) {
            if (windowCount[x] == 1) {
                ans = x;
            }
        }

        return ans;
    }
}