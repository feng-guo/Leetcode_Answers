/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {    
        Node next = head;
        
        Node newHead = null;
        
        Map<Node, Node> map = new HashMap<>();
        
        while (next != null) {
            Node newNode = new Node(next.val);
            if (newHead == null) {
                newHead = newNode;
            }
            map.put(next, newNode);
            next = next.next;
        }
        
        next = head;
        Node newNext = newHead;
        
        while (next != null) {
            newNext.next = map.get(next.next);
            if (next.random != null) {
                newNext.random = map.get(next.random);
            }
            next = next.next;
            newNext = newNext.next;
        }
        
        return newHead;
    }
}