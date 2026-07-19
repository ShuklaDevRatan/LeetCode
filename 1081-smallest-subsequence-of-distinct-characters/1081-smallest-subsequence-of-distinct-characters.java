class Solution {
    public String smallestSubsequence(String s) {

        // Stores the last occurrence of every character
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Stores the answer
        Stack<Character> stack = new Stack<>();

        // Tracks whether a character is already present in the stack
        boolean[] inStack = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            // Skip duplicates
            if (inStack[current - 'a']) {
                continue;
            }

            // Remove larger characters if they appear again later
            while (!stack.isEmpty()
                    && stack.peek() > current
                    && i < lastIndex[stack.peek() - 'a']) {

                char removed = stack.pop();
                inStack[removed - 'a'] = false;
            }

            // Add current character
            stack.push(current);
            inStack[current - 'a'] = true;
        }

        // Build final answer
        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}