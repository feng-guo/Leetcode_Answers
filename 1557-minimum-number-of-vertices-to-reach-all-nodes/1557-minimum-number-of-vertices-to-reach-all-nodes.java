class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> visitable = new HashSet<>();
        for (List<Integer> edge: edges) {
            visitable.add(edge.get(1));
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (visitable.add(i)) {
                res.add(i);
            }
        }
        return res;
    }
}