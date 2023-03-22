class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i=0; i<roads.length; i++) {
            map.get(roads[i][0]-1).add(new Pair(roads[i][1]-1, roads[i][2]));
            map.get(roads[i][1]-1).add(new Pair(roads[i][0]-1, roads[i][2]));
        }
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        list.add(0);
        int min = Integer.MAX_VALUE;
        
        while (!list.isEmpty()) {
            int current = list.remove(0);
            for (Pair<Integer, Integer> pair: map.get(current)) {
                min = Math.min(pair.getValue(), min);
                if (!visited[pair.getKey()]) {
                    visited[pair.getKey()] = true;
                    list.add(pair.getKey());
                }
            }
        }
        
        
        return min;
    }
}