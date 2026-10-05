class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        // Single plot
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                return n <= 1;
            } else {
                return n == 0;
            }
        }

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] != 0) {
                continue;
            }

            // First plot
            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

            // Last plot
            else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

            // Middle plot
            else {
                if (flowerbed[i - 1] == 0 &&
                    flowerbed[i + 1] == 0) {

                    flowerbed[i] = 1;
                    n--;
                }
            }

            if (n <= 0) {
                return true;
            }
        }

        return false;
    }
}