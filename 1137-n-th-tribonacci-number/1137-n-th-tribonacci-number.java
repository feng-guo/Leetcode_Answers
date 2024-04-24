class Solution {
    int[] list;
    public int tribonacci(int n) {
        if (n < 2) {
            list = new int[3];
        } else {
            list = new int[n+1];
        }
        for (int i=0; i<=n; i++) {
            list[i] = -1;
        }
        list[0] = 0;
        list[1] = 1;
        list[2] = 1;
        return t(n);
    }
    
    public int t(int n) {
        if (n < 0) {
            return 0;
        } else if (list[n] != -1) {
            return list[n];
        } else {
            list[n] = t(n-1) + t(n-2) + t(n-3);
            return list[n];
        }
    }
}