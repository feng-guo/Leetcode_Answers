class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> dupes = new HashSet<>();
        
        for (int i=0; i<nums.length; i++) {
            if (i-(k+1)>=0) {
                dupes.remove(nums[i-k-1]);
            }
            if (!dupes.add(nums[i])) {
                return true;
            }
        }
        
        return false;
    }
}