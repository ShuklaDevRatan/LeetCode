class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        int startLength = String.valueOf(low).length();
        int endLength = String.valueOf(high).length();
        endLength = Math.min(endLength, 9);

        for (int len = startLength; len <= endLength; len++) {

            // First sequential number (123..., length = len)
            int num = 0;
            for (int i = 1; i <= len; i++) {
                num = num * 10 + i;
            }

            // Difference = 11, 111, 1111...
            int diff = 0;
            for (int i = 0; i < len; i++) {
                diff = diff * 10 + 1;
            }

            while (true) {

                if (num >= low && num <= high) {
                    ans.add(num);
                }

                // Last digit is 9 -> no more sequential numbers of this length
                if (num % 10 == 9)
                    break;

                num += diff;
            }
        }

        return ans;
    }
}