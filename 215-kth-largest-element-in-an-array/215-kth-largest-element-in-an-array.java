class Solution {
    int max;
    int min;
    public int findKthLargest(int[] nums, int k) {
        max = 0;
        min = 0;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] bucket = new int[max-min+1];
        for (int num: nums) {
            // if (num > 0) {
                bucket[num-min]++;
            // }
        }
        
        for (int i=bucket.length-1; i>-1; i--) {
            if (bucket[i] > 0) {
                k-=bucket[i];
            }
            if (k<=0) {
                return i+min;
            }
        }
        return 0;
    }
}