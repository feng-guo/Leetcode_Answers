class Solution {
    public int trap(int[] height) {
        int ans =0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        int lm = 0;
        int rm = 0;
        for (int i=0; i<height.length; i++){
            if (height[i] > lm) {
                lm = height[i];
            }
            left_max[i] = lm;
        }
        for (int i=height.length-1; i>-1; i--) {
            if (height[i] > rm) {
                rm = height[i];
            }
            right_max[i] = rm;
        }
        for (int i=0; i<height.length; i++) {
            ans += Math.max(0, Math.min(left_max[i], right_max[i]) - height[i]);
        }
        return ans;
    }
}