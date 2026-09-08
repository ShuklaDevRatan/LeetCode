class Solution {
    public int countCommas(int n) {
        int ans = 0;

        for (int start = 1000; start <= n; start *= 1000) {
            ans += n - start + 1;

            if (start > n / 1000) {
                break;
            }
        }

        return ans;
    }
}