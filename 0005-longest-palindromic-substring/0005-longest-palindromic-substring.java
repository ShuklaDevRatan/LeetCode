class Solution {

    public String longestPalindrome(String s) {

        int maxLen = 1;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            int len1 = expandFromCenter(s, i, i);

            // Even length palindrome
            int len2 = expandFromCenter(s, i, i + 1);

            int currentLen = Math.max(len1, len2);

            if (currentLen > maxLen) {
                maxLen = currentLen;

                // Calculate starting index
                if (len1 >= len2) {
                    int left = i - (len1 - 1) / 2;
                    start = left;
                } else {
                    int left = i - (len2 / 2) + 1;
                    start = left;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expandFromCenter(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        // left and right are now one step outside the palindrome
        return right - left - 1;
    }
}