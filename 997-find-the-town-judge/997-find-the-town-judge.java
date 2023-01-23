class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] trusts: trust) {
            if (map.containsKey(trusts[1])) {
                map.put(trusts[1], map.get(trusts[1])+1);
            } else {
                map.put(trusts[1], 1);
            }
            set.add(trusts[0]);
        }
        for (int key: map.keySet()) {
            if (map.get(key) == n-1 && !set.contains(key)) {
                return key;
            }
        }
        return -1;
    }
}