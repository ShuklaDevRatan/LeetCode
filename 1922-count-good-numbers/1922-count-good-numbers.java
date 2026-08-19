class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = power(5, evenCount);
        long oddWays = power(4, oddCount);

        return (int) ((evenWays * oddWays) % MOD);
    }

    private long power(long x, long n) {
        if (n == 0) {
            return 1;
        }

        long ans = power(x, n / 2);

        if (n % 2 == 0) {
            return (ans * ans) % MOD;
        } else {
            return (ans * ans % MOD * x) % MOD;
        }
    }
}