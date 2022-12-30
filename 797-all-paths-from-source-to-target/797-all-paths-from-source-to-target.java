class Solution {
    Map<Integer, List<List<Integer>>> map;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        map = new HashMap<>();
        for (int c: graph[0]) {
            List<List<Integer>> list = st(graph, c);
            for (List<Integer> subList: list) {
                List<Integer> copy = new ArrayList<>(subList);
                copy.add(0, 0);
                res.add(copy);
            }
        }
        
        
        return res;
    }
    
    
    public List<List<Integer>> st(int[][] graph, int i) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        if (i == graph.length-1) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            res.add(list);
        } else {
            for (int c: graph[i]) {
                List<List<Integer>> list = st(graph, c);
                for (List<Integer> subList: list) {
                    List<Integer> copy = new ArrayList<>(subList);
                    copy.add(0, i);
                    res.add(copy);
                }
            }
        }
        map.put(i, res);
        return res;
    }
}