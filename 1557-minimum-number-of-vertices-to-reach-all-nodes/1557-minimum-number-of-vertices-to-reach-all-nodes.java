class Solution {
    Set<Integer> starts = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Set<Integer>> map = new HashMap<>();
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        for (int i=0; i<n; i++) {
            map.put(i, new HashSet<>());
        }
        for (List<Integer> edge: edges) {
            map.get(edge.get(0)).add(edge.get(1));
        }
        for (int i=0; i<n; i++) {
            if (visited.add(i)) {
                starts.add(i);
                dfs(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i: starts) {
            list.add(i);
        }
        return list;
    }
    
    public void dfs(int current) {
        for (int i: map.get(current)) {
            starts.remove(i);
            if (visited.add(i)) {
                dfs(i);
            }
        }
    }
}