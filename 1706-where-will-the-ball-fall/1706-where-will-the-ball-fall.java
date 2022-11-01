class Solution {
    public int[] findBall(int[][] grid) {
        int[] balls = new int[grid[0].length];
        for (int i=0; i<grid[0].length; i++) {
            balls[i] = traverse(grid, 0, 0, i);
        }
        
        return balls;
    }
    
    public int traverse(int[][] grid, int direction, int x, int y) {
        if (x == grid.length) {
            return y;
        }
        if (direction == 0) {
            if (grid[x][y] == 1) {
                //direct right
                if (y == grid[0].length-1) {
                    return -1;
                } else {
                    return traverse(grid, -1, x, y+1);
                }
            } else {
                //direct left
                if (y == 0) {
                    return -1;
                } else {
                    return traverse(grid, 1, x, y-1);
                }
            }
        } else if (direction == -1) {
            //coming from left
            if (grid[x][y] == -1) {
                return -1;
            } else {
                return traverse(grid, 0, x+1, y);
            }
        } else {
            if (grid[x][y] == 1) {
                return -1;
            } else {
                return traverse(grid, 0, x+1, y);
            }
        }
    }
}