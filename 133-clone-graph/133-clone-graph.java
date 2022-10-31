/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map;
    Set<Integer> set;
    Map<Integer, List<Integer>> connections;
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        map = new HashMap<>();
        set = new HashSet<>();
        connections = new HashMap<>();
        
        int start = node.val;
        
        explore(node);
        createNodes();
        
        return map.get(start);
    }
    
    public void explore(Node node) {
        if (set.add(node.val)) {
            List<Integer> neighbors = new ArrayList<>();
            
            for (Node neighbor: node.neighbors) {
                explore(neighbor);
                int val = neighbor.val;
                neighbors.add(val);
            }
            
            connections.put(node.val, neighbors);
        }
    }
    
    public void createNodes() {
        for (Integer val: set) {
            Node node = new Node(val);
            map.put(val, node);
        }
        for (Integer val: set) {
            Node node = map.get(val);
            List<Integer> neighborValues = connections.get(val);
            List<Node> neighbors = new ArrayList<>();
            
            for (Integer neighborValue: neighborValues) {
                node.neighbors.add(map.get(neighborValue));
            }
        }
    }
}