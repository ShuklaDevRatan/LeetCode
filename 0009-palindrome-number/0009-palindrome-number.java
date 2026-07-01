class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers palindrome nahi hote.
        // Aur jo number 0 par end hota hai (except 0), wo bhi palindrome nahi ho sakta.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // Even digits: x == reversedHalf
        // Odd digits: middle digit ignore karo
        return x == reversedHalf || x == reversedHalf / 10;
    }
}