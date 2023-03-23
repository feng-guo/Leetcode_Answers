class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) {
            return -1;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] connection: connections) {
            map.get(connection[0]).add(connection[1]);
            map.get(connection[1]).add(connection[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        int subnetworks = 0;
        for (int i=0; i<n; i++) {
            if (visited.add(i)) {
                subnetworks++;
                //DFS
                List<Integer> queue = new ArrayList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int current = queue.remove(0);
                    for (int conn: map.get(current)) {
                        if (visited.add(conn)) {
                            queue.add(conn);
                        }
                    }
                }
            }
        }
        return subnetworks - 1;
    }
}