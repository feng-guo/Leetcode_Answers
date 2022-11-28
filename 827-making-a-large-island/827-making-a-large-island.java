class Solution {
    public int largestIsland(int[][] grid) {
        int best = maxAreaOfIsland(grid);
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                current = 0;
                if (grid[i][j] == 0) {
                    Set<Integer> islands = new HashSet<>();
                    if (i != 0) {
                        int k = (i-1)*grid[0].length + j;
                        if (point_to_island.containsKey(k)) {
                            islands.add(point_to_island.get(k));
                        }
                    }
                    if (i != grid.length-1) {
                        int k = (i+1)*grid[0].length + j;
                        if (point_to_island.containsKey(k)) {
                            islands.add(point_to_island.get(k));
                        }
                    }
                    if (j != 0) {
                        int k = (i)*grid[0].length + j-1;
                        if (point_to_island.containsKey(k)) {
                            islands.add(point_to_island.get(k));
                        }
                    }
                    if (j != grid[0].length-1) {
                        int k = (i)*grid[0].length + j+1;
                        if (point_to_island.containsKey(k)) {
                            islands.add(point_to_island.get(k));
                        }
                    }
                    int total = 1;
                    for (int island: islands) {
                        total += island_size.get(island);
                    }
                    best = Math.max(best, total);
                }
            }
        }
        return best;
    }

    int current;
    Map<Integer, Integer> island_size;
    Map<Integer, Integer> point_to_island;
    
    public int maxAreaOfIsland(int[][] grid) {
        int id = 0;
        int best = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        island_size = new HashMap<>();
        point_to_island = new HashMap<>();
            
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                current = 0;
                if (grid[i][j] == 1 && !(visited[i][j])) {
                    explore(grid, i, j, visited, id);
                    best = Math.max(current, best);
                    island_size.put(id, current);
                    id++;
                }
            }
        }

        return best;
    }

        public void explore(int[][] grid, int x, int y, boolean[][] visited, int id) {
            if (!(x < 0 || y < 0 || x > grid.length-1 || y>grid[0].length-1 || grid[x][y] != 1 || visited[x][y])) {
                visited[x][y] = true;
                current++;
                point_to_island.put(x*grid[0].length + y, id);
                explore(grid, x-1, y, visited, id);
                explore(grid, x+1, y, visited, id);
                explore(grid, x, y-1, visited, id);
                explore(grid, x, y+1, visited, id);
            }
        }
}