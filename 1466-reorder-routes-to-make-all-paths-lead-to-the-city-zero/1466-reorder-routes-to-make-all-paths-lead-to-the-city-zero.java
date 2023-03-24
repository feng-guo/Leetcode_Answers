class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> connection_map = new HashMap<>();
        Map<Integer, Set<Integer>> directed_connection = new HashMap<>();
        List<Integer> queue = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        queue.add(0);
        for (int i=0; i<n; i++) {
            connection_map.put(i, new HashSet<>());
            directed_connection.put(i, new HashSet<>());
        }
        for (int[] connection: connections) {
            connection_map.get(connection[0]).add(connection[1]);
            connection_map.get(connection[1]).add(connection[0]);
            directed_connection.get(connection[0]).add(connection[1]);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.remove(0);
            for (int connection: connection_map.get(current)) {
                if (visited.add(connection)) {
                    queue.add(connection);
                    if (directed_connection.get(current).contains(connection)) {
                        directed_connection.get(current).add(connection);
                        directed_connection.get(connection).remove(current);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}