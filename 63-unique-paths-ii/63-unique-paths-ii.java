class Solution {    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i=0; i<obstacleGrid.length; i++) {
            for (int j=0; j<obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i > 0) {
                        obstacleGrid[i][j] += obstacleGrid[i-1][j];
                    }
                    if (j > 0) {
                        obstacleGrid[i][j] += obstacleGrid[i][j-1];
                    }
                } else if (obstacleGrid[i][j] == 1 && !(i == 0 && j == 0)) {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}