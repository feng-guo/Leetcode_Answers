class Solution {
    Set<Node> visited;
    public int removeStones(int[][] stones) {
        visited = new HashSet<>();
        Set<Node> node_set = new LinkedHashSet<>();
        int start = 0;
        Map<Integer, Set<Node>>  map = new HashMap<>();
        Map<Integer, Set<Node>>  map1 = new HashMap<>();
        for (int[] stone: stones) {
            Node node = new Node(stone[0], stone[1]);
            if (map.containsKey(stone[0])) {
                map.get(stone[0]).add(node);
            } else {
                Set<Node> set = new HashSet<>();
                set.add(node);
                map.put(stone[0], set);
            }
            if (map1.containsKey(stone[1])) {
                map1.get(stone[1]).add(node);
            } else {
                Set<Node> set = new HashSet<>();
                set.add(node);
                map1.put(stone[1], set);
            }
            node_set.add(node);
        }
        
        for(Node node: node_set) {
            for (Node conn: map.get(node.x)) {
                if (node != conn) {
                    node.add(conn);
                }
            }
            for (Node conn: map1.get(node.y)) {
                if (node != conn) {
                    node.add(conn);
                }
            }
        }
        
        
        for (Node node: node_set) {
            if (visited.add(node)) {
                start++;
                visit(node);
            }
        }
        
        return node_set.size() - start;
    }
    
    public void visit(Node node) {
        for (Node conn: node.set) {
            if (visited.add(conn)) {
                visit(conn);
            }
        }
    }
    
    public class Node {
        public Set<Node> set;
        public int x;
        public int y;
        
        public Node(int x, int y) {
            set = new HashSet<>();
            this.x = x;
            this.y = y;
        }
        
        public void add(Node node) {
            set.add(node);
        }
    }
}