class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int best = 0;
        for (int num: set) {
            int current = 0;
            if (!set.contains(num-1)) {
                while (set.contains(num)) {
                    num++;
                    current++;
                }
            }
            if (current > best) {
                best = current;
            }
        }
        return best;
    }
}