class Solution {
    public int strStr(String haystack, String needle) {

        int[] lps = new int[needle.length()];

        int prev = 0;
        int i = 1;

        while (i < needle.length()) {

            if (needle.charAt(i) == needle.charAt(prev)) {
                lps[i] = prev + 1;
                prev++;
                i++;
            } 
            else {
                if (prev != 0) {
                    prev = lps[prev - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        i = 0;
        int j = 0;

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }
            } 
            else {
                if (j != 0) {
                    j = lps[j - 1];
                } 
                else {
                    i++;
                }
            }
        }

        return -1;
    }
}