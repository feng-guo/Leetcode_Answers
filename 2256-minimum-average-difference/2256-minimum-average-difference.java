class Solution {
    public int minimumAverageDifference(int[] nums) {
        long total = 0;
        long sum = 0;
        for (int num: nums) {
            total += num;
        }
        
        long best = Integer.MAX_VALUE;
        int index = 0;
        
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            long front = sum/(i+1);
            long back = (total-sum);
            if (nums.length-i-1!=0) {
                back /= (nums.length-1-i);
            }
            if (Math.abs(front-back) < best) {
                best = Math.abs(front-back);
                index = i;
            }
            
        }
        
        return index;
    }
}