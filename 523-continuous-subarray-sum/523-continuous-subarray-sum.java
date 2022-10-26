class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // initialize the hash map with index 0 for sum 0
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if the remainder sum % k occurs for the first time
            if (!map.containsKey(sum % k)) {
                map.put(sum % k, i + 1);
            } else if (map.get(sum % k) < i) {
                return true;
            }
        }
        return false;
    }
}