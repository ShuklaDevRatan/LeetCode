class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            char digit = num.charAt(i);

            while (!stack.isEmpty() &&
                   k > 0 &&
                   stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // If k digits are still remaining, remove from end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the result
        StringBuilder result = new StringBuilder();

        for (char digit : stack) {
            result.append(digit);
        }

        // Remove leading zeros
        while (result.length() > 0 &&
               result.charAt(0) == '0') {

            result.deleteCharAt(0);
        }

        // If result is empty, return "0"
        return result.length() == 0 ? "0" : result.toString();
    }
}