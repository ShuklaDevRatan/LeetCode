class Solution {
    public int scoreOfParentheses(String s) {
        int[] stack = new int[s.length() + 1];
        int top = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                top++;
                stack[top] = 0;
            } 
            else {
                int current = stack[top];

                if (current == 0) {
                    current = 1;
                } else {
                    current = 2 * current;
                }

                top--;

                stack[top] += current;
            }
        }

        return stack[0];
    }
}