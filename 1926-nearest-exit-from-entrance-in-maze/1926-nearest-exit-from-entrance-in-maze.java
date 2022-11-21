class Solution {
    Map<Integer, Set<Integer>> visited;
    public int nearestExit(char[][] maze, int[] entrance) {
        visited = new HashMap<>();
        Map<Integer, Set<Integer>> queue = new HashMap<>();
        
        Set<Integer> ic = new HashSet<>();
        ic.add(entrance[1]);
        queue.put(entrance[0], ic);
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            Map<Integer, Set<Integer>> next = new HashMap<>();
            steps++;
            
            for (Integer row: queue.keySet()) {
                for (Integer column: queue.get(row)) {
                    if (row == 0 || row == maze.length-1 || column == 0 || column == maze[0].length-1) {
                        if (row != entrance[0] || column != entrance[1]) {
                            return steps-1;
                        }
                    }
                    
                    
                    if (row+1<maze.length && (!visited.containsKey(row+1) || visited.get(row+1).add(column)) && maze[row+1][column] == '.') {
                        add_visited(row+1, column, next);
                    }
                    if (row-1>-1 && (!visited.containsKey(row-1) || visited.get(row-1).add(column)) && maze[row-1][column] == '.') {
                        add_visited(row-1, column, next);
                    }
                    if (column+1<maze[0].length && (!visited.containsKey(row) || visited.get(row).add(column+1)) && maze[row][column+1] == '.') {
                        add_visited(row, column+1, next);
                    }
                    if (column-1>-1 && (!visited.containsKey(row) || visited.get(row).add(column-1)) && maze[row][column-1] == '.') {
                        add_visited(row, column-1, next);
                    }
                }
            }
            
            
            queue = next;
        }
        return -1;
    }
    
    public void add_visited(int row, int column, Map<Integer, Set<Integer>> next) {
        if (visited.containsKey(row)) {
            visited.get(row).add(column);
        } else {
            Set<Integer> c = new HashSet<>();
            c.add(column);
            visited.put(row, c);
        }
        if (next.containsKey(row)) {
            next.get(row).add(column);
        } else {
            Set<Integer> c = new HashSet<>();
            c.add(column);
            next.put(row, c);
        }
    }
}