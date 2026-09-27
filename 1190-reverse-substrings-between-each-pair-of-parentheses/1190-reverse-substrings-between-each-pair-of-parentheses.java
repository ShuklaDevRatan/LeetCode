class Solution {
    public String reverseParentheses(String s) {

        int n = s.length();

        int[] pair = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Find matching parentheses
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else if (s.charAt(i) == ')') {

                int open = stack.pop();

                pair[open] = i;
                pair[i] = open;
            }
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;
        int direction = 1;

        while (i < n) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == ')') {

                i = pair[i];
                direction = -direction;

            } else {

                ans.append(ch);
            }

            i += direction;
        }

        return ans.toString();
    }
}