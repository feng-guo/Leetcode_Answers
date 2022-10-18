class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] top_k = new int[k];
        Map<Integer, Integer> m = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            if (m.containsKey(num)) {
                m.put(num, m.get(num) + 1);
                if (m.get(num) > max) {
                    max = m.get(num);
                }
            } else {
                m.put(num, 1);
                if (1 > max) {
                    max = 1;
                }
            }
        }
        List<Integer>[] count = new List[max+1];
        // for (int i=0; i<max; i++) {
        //     count[i] = Integer.MIN_VALUE;
        // }
        for (Integer key: m.keySet()) {
            if (count[m.get(key)] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                count[m.get(key)] = list;
            } else {
                count[m.get(key)].add(key);
            }
        }
        int i=0;
        while(i<k) {
            if (count[max] != null) {
                for (Integer k_int: count[max]) {
                    top_k[i] = k_int;
                    i++; 
                }
            }
            max--;
        }
        return top_k;
    }
}