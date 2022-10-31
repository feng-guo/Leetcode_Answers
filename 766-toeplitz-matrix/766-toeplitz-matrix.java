class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (i+j < matrix.length && matrix[i+j][j] != matrix[i][0]) {
                    return false;
                }
            }
        }
        
        for(int i=1; i<matrix[0].length; i++) {
            for (int j=1; j<matrix.length; j++) {
                if (i+j < matrix[0].length && matrix[j][i+j] != matrix[0][i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}