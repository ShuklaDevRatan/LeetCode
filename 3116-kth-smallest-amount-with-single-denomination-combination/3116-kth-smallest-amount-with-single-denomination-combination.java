class Solution {

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    long count(long x, int[] coins, int index, long currentLcm, int selected) {

        if (index == coins.length) {

            if (selected == 0) {
                return 0;
            }

            long ways = x / currentLcm;

            return selected % 2 == 1 ? ways : -ways;
        }

        // Don't take this coin
        long exclude = count(
                x,
                coins,
                index + 1,
                currentLcm,
                selected
        );

        // Take this coin
        long newLcm = lcm(currentLcm, coins[index]);

        long include = count(
                x,
                coins,
                index + 1,
                newLcm,
                selected + 1
        );

        return exclude + include;
    }

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) 1e11;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long total = count(mid, coins, 0, 1, 0);

            if (total >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}