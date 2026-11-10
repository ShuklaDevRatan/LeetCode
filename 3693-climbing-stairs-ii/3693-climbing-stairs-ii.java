import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, n, costs, dp);
    }

    public int solve(int i, int n, int[] costs, int[] dp) {

        // Base Case
        if (i == n) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        // Jump 1, 2 or 3 steps
        for (int jump = 1; jump <= 3; jump++) {

            int next = i + jump;

            if (next <= n) {

                int cost = costs[next - 1] + jump * jump;

                cost += solve(next, n, costs, dp);

                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i] = minCost;
    }
}