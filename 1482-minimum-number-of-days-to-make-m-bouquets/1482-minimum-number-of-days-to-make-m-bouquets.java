class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int bouquets = 0;
            int flowers = 0;

            for (int day : bloomDay) {

                if (day <= mid) {
                    flowers++;
                } else {
                    bouquets += flowers / k;
                    flowers = 0;
                }
            }

            bouquets += flowers / k;

            if (bouquets >= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}