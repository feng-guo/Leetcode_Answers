class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile: piles) {
            right = Math.max(pile, right);
        }
        while (left < right) {
            int mid = (left+right)/2;
            
            boolean mid_ok = true;
            int time_remaining = h;
            for (int pile: piles) {
                time_remaining -= Math.ceil( (double) pile / (double) mid);
                if (time_remaining < 0) {
                    mid_ok = false;
                    break;
                }
            }
            
            if (mid_ok) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}