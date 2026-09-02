class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddCount = 0;

        for (int num : nums1) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        return true;
    }
}