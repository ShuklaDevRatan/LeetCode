class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];
        long[] current = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            int remainder = num % k;

            // Current element khud ek subarray hai
            next[remainder]++;
            result[remainder]++;

            // Previous subarrays ko current element ke saath extend karo
            for (int r = 0; r < k; r++) {

                if (current[r] > 0) {

                    int newRemainder = (r * remainder) % k;

                    next[newRemainder] += current[r];
                    result[newRemainder] += current[r];
                }
            }

            current = next;
        }

        return result;
    }
}