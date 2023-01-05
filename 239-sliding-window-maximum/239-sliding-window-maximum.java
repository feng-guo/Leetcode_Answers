class Solution {
    ArrayDeque<Integer> dq;
    int[] nums;
    int k;
    
    public void clean(int i) {
        while (!dq.isEmpty() && dq.getFirst() <= i-k) {
            dq.removeFirst();
        }
        while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
            dq.removeLast();
        }
    }
    
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        } else if (k == 1) {
            return nums;
        }
        this.k = k;
        this.nums = nums;
        this.dq = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        
        int max = 0;
        for (int i=0; i<k; i++) {
            clean(i);
            dq.addLast(i);
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        res[0] = nums[max];
        int index = 1;
        for (int i=k; i<nums.length; i++) {
            clean(i);
            dq.addLast(i);
            res[index] = nums[dq.getFirst()];
            index++;
        }
        
        return res;
    }
}