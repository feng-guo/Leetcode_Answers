class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int rotten = 0;
        int new_rotten = 0;
        int time = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotten++;
                    queue.add(i*n + j);
                }
            }
        }
        
        while (queue.size()> 0) {
            new_rotten = 0;
            int old_fresh = fresh;
            for (int i=0; i<rotten; i++) {
                int coordinate = queue.poll();
                int x = coordinate/n;
                int y = coordinate%n;
                if (x!=0 && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    new_rotten++;
                    fresh--;
                    queue.add((x-1)*n+y);
                }
                if (x!=m-1 && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    new_rotten++;
                    fresh--;
                    queue.add((x+1)*n+y);
                }
                if (y!=0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    new_rotten++;
                    fresh--;
                    queue.add(x*n+(y-1));
                }
                if (y!=n-1 && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    new_rotten++;
                    fresh--;
                    queue.add(x*n+(y+1));
                }
                
            }
            if (fresh != old_fresh) {
                time++;
            }
            rotten = new_rotten;
        }
        
        if (fresh != 0) {
            return -1;
        } else {
            return time;
        }
        
    }
}