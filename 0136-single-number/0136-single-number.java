class Solution {
    public int singleNumber(int[] nums) {

        // Initially answer ko 0 se start karte hain.
        // XOR ki property:
        // 0 ^ x = x
        int ans = 0;

        // Har element ke saath XOR karte jao.
        for (int num : nums) {

            // Duplicate elements cancel ho jayenge.
            // x ^ x = 0
            // Last me sirf unique element bachega.
            ans ^= num;
        }

        // Unique element return karo.
        return ans;
    }
}