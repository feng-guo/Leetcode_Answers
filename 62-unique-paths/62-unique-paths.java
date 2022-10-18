class Solution {
    public int uniquePaths(int m, int n) {
        int[][] moves = new int[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int top = 0;
                int left = 0;
                if (i != 0) {
                    top = moves[i-1][j];
                    // System.out.println("top" + "" + top);
                }
                if (j != 0) {
                    left = moves[i][j-1];
                    // System.out.println("left" + "" + left);
                }
                if (i != 0 || j != 0) {
                    moves[i][j] = top + left;
                    // System.out.println(moves[i][j] + " " + top + " "  + left);
                } else {
                    moves[0][0] = 1;
                }
            }
        }
        return moves[m-1][n-1];
    }
}