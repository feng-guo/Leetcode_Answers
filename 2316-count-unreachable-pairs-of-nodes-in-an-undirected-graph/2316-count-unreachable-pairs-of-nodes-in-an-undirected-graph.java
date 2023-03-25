class Solution {
    public long countPairs(int n, int[][] edges) {
        long count = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[1]);
                map.put(edge[0], set);
            }
            if (map.containsKey(edge[1])) {
                map.get(edge[1]).add(edge[0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[0]);
                map.put(edge[1], set);
            }
        }
        
        for (int i=0; i<n; i++) {
            if (visited.add(i)) {
                long current = 0;
                q.add(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    current++;
                    if (map.containsKey(node)) {
                        for (int edge: map.get(node)) {
                            if (visited.add(edge)) {
                                q.add(edge);
                            }
                        }
                    }
                }
                count += current * (n-current);
            }
            
        }
        
        
        return (long) count/2;
    }
}