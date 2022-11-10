class BrowserHistory {
    LN head;
    int size;
    int current;
    Map<Integer, LN> map;
    
    public BrowserHistory(String homepage) {
        head = new LN(homepage);
        map = new HashMap<>();
        size = 1;
        current = 0;
        map.put(0, head);
    }
    
    public void visit(String url) {
        LN visit = new LN(url);
        map.get(current).setNext(visit);
        current++;
        map.put(current, visit);
        size = current +1;
    }
    
    public String back(int steps) {
        current = Math.max(0, current-steps);
        return map.get(current).url;
    }
    
    public String forward(int steps) {
        current = Math.min(size-1, current+steps);
        return map.get(current).url;
    }
    
    class LN {
        String url;
        LN next;
        
        public LN(String url) {
            this.url = url;
            this.next = null;
        }
        
        public void setNext(LN next) {
            this.next = next;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */