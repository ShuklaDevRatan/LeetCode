class Solution {
    public int smallestNumber(int n, int t) {
        while(!productOfDigits(n, t)){
            n++;
        }
        return n;
    }

    private Boolean productOfDigits(int n,int t) {
        int product = 1;
        while (n > 0) {
            int rem = n % 10;
            product *= rem;
            n /= 10;
        }

        return product%t==0?true:false;
    }
}