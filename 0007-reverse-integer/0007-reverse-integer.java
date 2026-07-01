class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int r = x % 10;
            x /= 10;

            // Overflow hone se pehle check
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && r > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && r < -8))
                return 0;

            rev = rev * 10 + r;
        }
        return rev;
    }
}
