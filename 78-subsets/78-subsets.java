class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int max = (int) Math.pow(2, nums.length);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());
        for (int i=1; i<max; i++) {
            List<Integer> currentList = new ArrayList<>();
            int currentSubset = i;
            int currentIndex = 0;
            while (currentSubset > 0) {
                if (currentSubset%2 == 1) {
                    currentList.add(nums[currentIndex]);
                }
                currentSubset >>= 1;
                currentIndex++;
            }
            res.add(currentList);
        }
        return res;
    }
}