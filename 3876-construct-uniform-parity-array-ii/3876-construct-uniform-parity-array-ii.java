class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;

        for (int num : nums1) {
            min = Math.min(min, num);
        }

        // Minimum odd hai → sabko odd bana sakte hain
        if (min % 2 != 0) {
            return true;
        }

        // Minimum even hai → koi odd element nahi hona chahiye
        for (int num : nums1) {
            if (num % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}