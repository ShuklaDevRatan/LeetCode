class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int ones = 0;

        int minLength = Integer.MAX_VALUE;
        String minString = s;

        for (int right = 0; right < s.length(); right++) {

            // Expand window
            if (s.charAt(right) == '1') {
                ones++;
            }

            // Window has exactly k ones
            while (ones == k) {

                int currentLength = right - left + 1;
                String current = s.substring(left, right + 1);

                // Shorter window
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minString = current;
                }

                // Same length but lexicographically smaller
                else if (currentLength == minLength
                        && current.compareTo(minString) < 0) {
                    minString = current;
                }

                // Shrink window
                if (s.charAt(left) == '1') {
                    ones--;
                }

                left++;
            }
        }

        // No beautiful substring exists
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return minString;
    }
}