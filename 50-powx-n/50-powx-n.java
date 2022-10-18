class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        
        return half_pow(x, n);
    }
    
    public double half_pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = half_pow(x, n/2);
        if (n%2 ==0) {
            return half*half;
        } else {
            return half*half*x;
        }
    }
}