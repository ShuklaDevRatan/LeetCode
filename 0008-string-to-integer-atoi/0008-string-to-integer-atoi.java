class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // 1. Leading spaces skip karo
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Sign check karo
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        // 3. Number build karo
        long num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            // 4. Overflow check
            if (sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // 5. Sign apply karke return
        return (int) (num * sign);
    }
}