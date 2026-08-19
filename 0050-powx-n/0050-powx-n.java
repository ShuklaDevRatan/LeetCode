class Solution {
    public double myPow(double x, int n) {
         if(n == 0) return 1.000 ;
       return n < 0 ? 1/power(x, -n) : power(x, n);
    }

    double power(double x , int n){
        if(n == 0)return 1;
        double ans = power(x,n/2);
        if(n%2==0)return ans*ans;
        else return ans*ans*x ;

    }

}