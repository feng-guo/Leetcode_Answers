class Solution {
    public int countComponents(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int i=0; i<edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edges[i][1]);
                map.put(edges[i][0], set);
            }
            if (map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edges[i][0]);
                map.put(edges[i][1], set);
            }
        }
        
        int count = 0;
        
        for (int i=0; i<n; i++) {
            if (visited.add(i)) {
                count++;
                visit(visited, map, i);
            }
        }
        
        return count;
    }
    
    
    public void visit(Set<Integer> visited, Map<Integer, Set<Integer>> c, int i) {
        if (c.containsKey(i)) {
            for (int conn: c.get(i)) {
                if (visited.add(conn)) {
                    visit(visited, c, conn);
                }
            }
        }
    }
}