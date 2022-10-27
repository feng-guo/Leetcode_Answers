class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int max = 0;
        int n = img1.length;
        for (int i=(-n); i<n; i++) {
            for(int j=(-n); j<n; j++) {
                int count = 0;
                for (int k=0; k<n; k++) {
                    for (int m=0; m<n; m++) {
                        if (k+i > -1 && m+j > -1 && k+i < n && m + j < n && img1[k+i][j+m] == 1 && img2[k][m] == 1) {
                            count++;
                        }
                    }
                }
                max = Math.max(count, max);
            }
        }
        
        return max;
    }
}