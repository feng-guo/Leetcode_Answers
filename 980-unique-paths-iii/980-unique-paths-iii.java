class Solution {
    int sx;
    int sy;
    int count;
    int s;
    
    public int uniquePathsIII(int[][] grid) {
        s = 0;
        count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    s++;
                } else if (grid[i][j] == 1) {
                    s++;
                    sx = i;
                    sy = j;
                }
            }
        }
        path(grid, sx, sy, 0);
        return count;
    }
    
    public void path(int[][] grid, int x, int y, int current) {
        if (grid[x][y] == 2) {
            if (current == s) {
                count++;
            }
        } else if (grid[x][y] == 0 || grid[x][y] == 1) {
            int t = grid[x][y];
            grid[x][y] = -1;
            if (x > 0) {
                path(grid, x-1, y, current+1);
            }
            if (x < grid.length-1) {
                path(grid, x+1, y, current+1);
            }
            if (y > 0) {
                path(grid, x, y-1, current+1);
            }
            if (y < grid[0].length-1) {
                path(grid, x, y+1, current+1);
            }
            
            grid[x][y] = t;
        }
    }
}