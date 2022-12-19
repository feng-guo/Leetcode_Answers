class Solution {
    Map<Integer, Set<Integer>> map;
    Set<Integer> set;
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        map = new HashMap<>();
        set = new HashSet<>();
        for (int[] edge: edges) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                Set<Integer> next = new HashSet<>();
                next.add(edge[1]);
                map.put(edge[0], next);
            }
            if (map.containsKey(edge[1])) {
                map.get(edge[1]).add(edge[0]);
            } else {
                Set<Integer> next = new HashSet<>();
                next.add(edge[0]);
                map.put(edge[1], next);
            }
        }
        set.add(source);
        return valid(source, destination);
    }
    
    public boolean valid(int source, int destination) {
        if (source == destination) {
            return true;
        }
        for (Integer next: map.get(source)) {
            if (set.add(next) && valid(next, destination)) {
                return true;
            }
        }
        return false;
    }
}