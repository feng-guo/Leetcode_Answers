class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        double d_n = (double) n;
        int cap = (int)Math.ceil(Math.sqrt((double)n*2));
        for (double i=1; i<cap; i++) {
            if (i%2 == 0) {
                if ((d_n/i)%1 == 0.5) {
                    count++;
                }
            } else {
                if (d_n%i==0) {
                    count++;
                }
            }
        }
        return count;
    }
}