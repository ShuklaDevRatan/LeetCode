class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        // Total sum = prefix[n - 1]
        int prefixSum = 0;

        for (int stone : stones) {
            prefixSum += stone;
        }

        // Initially P[n - 1]
        int ans = prefixSum;

        // We need P[i], i = n-2 ... 1
        for (int i = n - 2; i >= 1; i--) {

            // Remove stones[i + 1] from current prefix
            // to get P[i]
            prefixSum -= stones[i + 1];

            ans = Math.max(ans, prefixSum - ans);
        }

        return ans;
    }
}