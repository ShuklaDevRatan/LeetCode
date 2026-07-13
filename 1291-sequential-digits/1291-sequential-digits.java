class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        // Base sequential string
        String digits = "123456789";

        // Possible digit lengths
        int startLength = String.valueOf(low).length();
        int endLength = Math.min(String.valueOf(high).length(), 9);

        // Generate numbers of every valid length
        for (int len = startLength; len <= endLength; len++) {

            // Sliding window over "123456789"
            for (int i = 0; i <= 9 - len; i++) {

                // Extract sequential number
                int num = Integer.parseInt(digits.substring(i, i + len));

                // Keep only numbers within range
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}