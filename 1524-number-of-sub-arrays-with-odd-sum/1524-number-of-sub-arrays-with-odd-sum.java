class Solution {
    public int numOfSubarrays(int[] arr) {

        int MOD = 1_000_000_007;

        int even = 1;
        int odd = 0;

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {

            prefixSum += num;

            if (prefixSum % 2 == 0) {
                count += odd;
                even++;
            } 
            else {
                count += even;
                odd++;
            }

            count %= MOD;
        }

        return count;
    }
}