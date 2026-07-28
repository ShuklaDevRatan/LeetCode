class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] ans = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;

        for (int i = 0; i < 26; i++) {

            // Place pairs directly
            while (freq[i] >= 2) {
                ans[left++] = (char) (i + 'a');
                ans[right--] = (char) (i + 'a');
                freq[i] -= 2;
            }
            
            // Remaining odd character goes to the middle
            if (freq[i] == 1) {
                ans[s.length() / 2] = (char) (i + 'a');
            }
        }

        return new String(ans);
    }
}