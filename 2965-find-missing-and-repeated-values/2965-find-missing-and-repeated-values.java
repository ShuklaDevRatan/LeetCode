class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int m = n * n;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int[] row : grid) {
            for (int num : row) {
                actualSum += num;
                actualSquareSum += (long) num * num;
            }
        }

        long expectedSum = (long) m * (m + 1) / 2;
        long expectedSquareSum =
                (long) m * (m + 1) * (2L * m + 1) / 6;

        // a - b
        long diff = actualSum - expectedSum;

        // a² - b² = (a-b)(a+b)
        long squareDiff = actualSquareSum - expectedSquareSum;

        // a + b
        long sum = squareDiff / diff;

        int repeated = (int) ((diff + sum) / 2);
        int missing = (int) ((sum - diff) / 2);

        return new int[]{repeated, missing};
    }
}