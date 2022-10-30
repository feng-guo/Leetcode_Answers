class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    explore(grid, i-1, j);
                    explore(grid, i+1, j);
                    explore(grid, i, j-1);
                    explore(grid, i, j+1);
                }
            }
        }
        
        
        return islands;
    }
    
    public void explore(char[][] grid, int x, int y) {
        if (!(x < 0 || y < 0 || x > grid.length-1 || y>grid[0].length-1 || grid[x][y] != '1')) {
            grid[x][y] = 0;
            explore(grid, x-1, y);
            explore(grid, x+1, y);
            explore(grid, x, y-1);
            explore(grid, x, y+1);
        }
    }
}