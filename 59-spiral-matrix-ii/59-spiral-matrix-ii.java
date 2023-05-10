class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        int direction = 1;
        int x = 0;
        int y = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n*n; i++) {
            matrix[x][y] = i;
            if (direction == 1) {
                if (y == matrix[0].length-1 || matrix[x][y+1] != 0) {
                    direction = 2;
                    x++;
                } else {
                    y++;
                }
            } else if (direction == 2) {
                if (x == matrix.length-1 || matrix[x+1][y] != 0) {
                    direction = 3;
                    y--;
                } else {
                    x++;
                }
            } else if (direction == 3) {
                if (y == 0 || matrix[x][y-1] != 0) {
                    direction = 4;
                    x--;
                } else {
                    y--;
                }
            } else if (direction == 4) {
                if (matrix[x-1][y] != 0) {
                    direction = 1;
                    y++;
                } else {
                    x--;
                }
            }
        }
        return matrix;
    }
}