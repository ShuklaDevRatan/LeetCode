class Solution {
    public String reverseParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(sb.length());
            } 
            else if (ch == ')') {

                int start = stack.pop();

                StringBuilder temp = new StringBuilder(
                    sb.substring(start)
                );

                temp.reverse();

                sb.replace(start, sb.length(), temp.toString());

            } 
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}