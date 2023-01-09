class LRUCache {
    DListMap map;
    
    public LRUCache(int capacity) {
        map = new DListMap(capacity);  
    }
    
    public int get(int key) {
        return map.get(key);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
    
    private class DListMap {
        Map<Integer, Node> map;
        Node head;
        Node tail;
        int size;
        int capacity;
        
        private class Node {
            Node next;
            Node prev;
            int key;
            int value;
            
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        
        public DListMap(int capacity) {
            map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            this.size = 0;
        } 
        
        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = tail.prev;
                node.next = tail;
                tail.prev.next = node;
                tail.prev = node;
                return node.value;
            } else {
                return -1;
            }
        }
        
        public void put(int key, int value) {
            Node node;
            if (map.containsKey(key)) {
                get(key);
                node = map.get(key);
                node.value = value;
            } else {
                if (size == capacity) {
                    Node remove = head.next;
                    head.next = head.next.next;
                    head.next.prev = head;
                    map.remove(remove.key);
                } else {
                    size++;
                }
                node = new Node(key, value);
                node.prev = tail.prev;
                node.next = tail;
                tail.prev.next = node;
                tail.prev = node; 
            }
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */