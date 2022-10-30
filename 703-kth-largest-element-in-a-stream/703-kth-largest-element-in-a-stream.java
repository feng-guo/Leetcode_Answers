class KthLargest {

    int k;
    PriorityQueue<Integer> min;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        min = new PriorityQueue<>();
        
        for (int i=0; i<nums.length; i++) {
            if (min.size() == k) {
                if (nums[i] > min.peek()) {
                    min.poll();
                    min.add(nums[i]);
                }
            } else {
                min.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if (min.size() == k) {
            if (val > min.peek()) {
                min.poll();
                min.add(val);
            }
        } else {
            min.add(val);
        }
        return min.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */