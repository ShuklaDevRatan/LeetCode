class Solution {
    public int missingMultiple(int[] nums, int k) {
        for (int i = 1;; i++) {
            int multiple = k * i;

            boolean found = false;
            for (int num : nums) {
                if (num == multiple) {
                    found = true;
                    break;
                }
            }

            if (!found)
                return multiple;
        }
    }
}