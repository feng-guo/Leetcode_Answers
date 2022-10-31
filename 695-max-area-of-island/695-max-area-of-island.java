class Solution {
    int current;
    public int maxAreaOfIsland(int[][] grid) {
        int best = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                current = 0;
                if (grid[i][j] == 1) {
                    explore(grid, i, j);
                    best = Math.max(best, current);
                }
            }
        }
        
        return best;
    }
    
    public void explore(int[][] grid, int x, int y) {
        if (!(x < 0 || y < 0 || x > grid.length-1 || y>grid[0].length-1 || grid[x][y] != 1)) {
            grid[x][y] = 0;
            current++;
            explore(grid, x-1, y);
            explore(grid, x+1, y);
            explore(grid, x, y-1);
            explore(grid, x, y+1);
        }
    }
}