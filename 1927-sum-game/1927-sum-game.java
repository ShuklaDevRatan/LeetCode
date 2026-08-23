class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < half; i++) {
            char ch = num.charAt(i);

            if (ch == '?') {
                leftQ++;
            } else {
                leftSum += ch - '0';
            }
        }

        for (int i = half; i < n; i++) {
            char ch = num.charAt(i);

            if (ch == '?') {
                rightQ++;
            } else {
                rightSum += ch - '0';
            }
        }

        int diff = leftSum - rightSum;
        int qDiff = leftQ - rightQ;

        return diff * 2 != -9 * qDiff;
    }
}