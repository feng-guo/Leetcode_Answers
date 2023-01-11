class Solution {
    public int dfs(int node, int parent, Map<Integer, List<Integer>> adj,
            List<Boolean> hasApple) {
        if (!adj.containsKey(node))
            return 0;

        int totalTime = 0, childTime = 0;
        for (int child : adj.get(node)) {
            if (child == parent)
                continue;
            childTime = dfs(child, node, adj, hasApple);
            // childTime > 0 indicates subtree of child has apples. Since the root node of the
            // subtree does not contribute to the time, even if it has an apple, we have to check it
            // independently.
            if (childTime > 0 || hasApple.get(child))
                totalTime += childTime + 2;
        }
        return totalTime;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        return dfs(0, -1, adj, hasApple);
    }
}
// class Solution {
//     Map<Integer, Boolean> map;
//     Map<Integer, Set<Integer>> edgeMap;
    
//     public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
//         map = new HashMap<>();
//         edgeMap = new HashMap<>();
        
//         for (int i=0; i<hasApple.size(); i++) {
//             map.put(i, hasApple.get(i));
//         }
        
//         for (int[] edge: edges) {
//             if (edgeMap.containsKey(edge[0])) {
//                 edgeMap.get(edge[0]).add(edge[1]);
//             } else {
//                 Set<Integer> set = new HashSet<>();
//                 set.add(edge[1]);
//                 edgeMap.put(edge[0], set);
//             }
//         }
//         computeApple(0);
        
//         return computePath(0);
//     }
    
//     public boolean computeApple(int root) {
//         boolean res = map.get(root);
//         if (edgeMap.containsKey(root)) {
//             for (Integer node: edgeMap.get(root)) {
//                 if (computeApple(node)) {
//                     res = true;
//                 }
//             }
//             map.put(root, res);
//         }
//         return res || map.get(root);
//     }
    
//     public int computePath(int root) {
//         int res = 0;
//         if (edgeMap.containsKey(root)) {
//            for (Integer node: edgeMap.get(root)) {
//                 if (map.get(node)) {
//                     res += computePath(node) + 2;
//                 }
//             } 
//         }
//         System.out.println(root + " " + res);
//         return res;
//     }
// }