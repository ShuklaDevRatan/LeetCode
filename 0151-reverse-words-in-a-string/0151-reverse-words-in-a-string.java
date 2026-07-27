class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(words[i]);
            }
        }

        return sb.toString();
    }
}