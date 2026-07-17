class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Maximum pile find karo
        for (int bananas : piles) {
            right = Math.max(right, bananas);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = calculateHours(piles, mid);

            if (hours <= h) {
                // Mid speed par kaam ho gaya,
                // aur chhoti speed try karo
                right = mid;
            } else {
                // Speed kam hai
                left = mid + 1;
            }
        }

        return left;
    }

    private long calculateHours(int[] piles, int speed) {

        long hours = 0;

        for (int bananas : piles) {
            hours += (bananas + speed - 1) / speed;
        }

        return hours;
    }
}