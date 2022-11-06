class MedianFinder {
    
    Queue<Integer> top;
    Queue<Integer> bottom;

    public MedianFinder() {
        top = new PriorityQueue<>();
        bottom = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (bottom.isEmpty() || num <= bottom.peek()) {
            bottom.add(num);
        } else {
            top.add(num);
        }
        
        if (bottom.size()-1 > top.size()) {
            top.add(bottom.poll());
        } else if (top.size()-1 > bottom.size()) {
            bottom.add(top.poll());
        }
    }
    
    public double findMedian() {
        if (top.size() > bottom.size()) {
            return top.peek();
        } else if (top.size() == bottom.size()) {
            return ((double)top.peek() + bottom.peek())/2;
        } else {
            return bottom.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */