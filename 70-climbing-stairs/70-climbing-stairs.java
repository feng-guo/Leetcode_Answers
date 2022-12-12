class Solution {
    Map<Integer, Integer> m;
    
    public int climbStairs(int n) {
        if (m == null) {
            m = new HashMap<>();
        }
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        if (m.containsKey(n)) {
            return m.get(n);
        } else {
            m.put(n, climbStairs(n-1) + climbStairs(n-2));
            return m.get(n);
        }
    }
}