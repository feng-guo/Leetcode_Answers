class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> from = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        
        Set<Integer> visited = new HashSet<>();
        
        for (int i=0; i<edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                Set<Integer> c = new HashSet<>();
                c.add(edges[i][1]);
                map.put(edges[i][0], c);
            }
            if (map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                Set<Integer> c = new HashSet<>();
                c.add(edges[i][0]);
                map.put(edges[i][1], c);
            }
        }
        q.add(0);
        visited.add(0);
        while (!q.isEmpty()) {
            int current = q.poll();
            if (map.containsKey(current)) {
                for (int c: map.get(current)) {
                    if (!visited.add(c)) {
                        if (from.containsKey(current) && from.get(current) == c) {
                            //Fine
                        } else {
                            return false;
                        }
                    } else {
                        from.put(c, current);
                        q.add(c);
                    }
                }
            } else {
                return n == 1;
            }
        }
        
        return visited.size() == n;
    }
}