class Solution {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        boolean done = false;
        while (n != 1 && !done) {
            if (n%2 != 0) {
                done = true;
            } else {
                n /= 2;
            }
        }
        done = false;
        while (n != 1 && !done) {
            if (n%3 != 0) {
                done = true;
            } else {
                n /= 3;
            }
        }
        done = false;
        while (n != 1 && !done) {
            if (n%5 != 0) {
                done = true;
            } else {
                n /= 5;
            }
        }
        return n==1;
    }
}