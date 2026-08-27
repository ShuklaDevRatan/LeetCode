class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Frequency of characters in s
        int[] sFreq = new int[26];

        for (char ch : s.toCharArray()) {
            sFreq[ch - 'a']++;
        }

        // Frequency of target[0 ... n-2]
        int[] prefixFreq = new int[26];

        for (int i = 0; i < n - 1; i++) {
            prefixFreq[target.charAt(i) - 'a']++;
        }

        // Try to make the first difference as far right as possible
        for (int i = n - 1; i >= 0; i--) {

            // Check whether target[0 ... i-1]
            // can be formed using characters of s
            boolean possible = true;

            for (int j = 0; j < 26; j++) {
                if (prefixFreq[j] > sFreq[j]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {

                // Characters left after creating the prefix
                int[] remaining = sFreq.clone();

                for (int j = 0; j < 26; j++) {
                    remaining[j] -= prefixFreq[j];
                }

                int current = target.charAt(i) - 'a';

                // Find smallest character greater than target[i]
                for (int j = current + 1; j < 26; j++) {

                    if (remaining[j] > 0) {

                        StringBuilder ans = new StringBuilder();

                        // Keep target[0 ... i-1]
                        ans.append(target, 0, i);

                        // First different character
                        ans.append((char) ('a' + j));

                        remaining[j]--;

                        // Add remaining characters in sorted order
                        for (int k = 0; k < 26; k++) {
                            while (remaining[k] > 0) {
                                ans.append((char) ('a' + k));
                                remaining[k]--;
                            }
                        }

                        return ans.toString();
                    }
                }
            }

            // Moving from i to i-1 means
            // target[i-1] is no longer part of the prefix.
            if (i > 0) {
                prefixFreq[target.charAt(i - 1) - 'a']--;
            }
        }

        return "";
    }
}