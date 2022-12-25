class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            count+=nums[i];
            list.add(count);
        }
        for (int c: list) {
            System.out.println(c);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int i=0; i<queries.length; i++) {
            if (map.containsKey(queries[i])) {
                map.get(queries[i]).add(i);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                map.put(queries[i], index);
                m2.put(queries[i], 0);
            }
        }
        
        int[] res = new int[queries.length];
        int index = 0;
        Arrays.sort(queries);
        for (int query: queries) {
            if (query >= sum) {
                res[map.get(query).get(m2.get(query))] = nums.length;
                m2.put(query, m2.get(query)+1);
            } else {
                while (query >= list.get(index)) {
                    index++;
                }
                res[map.get(query).get(m2.get(query))] = index;
                m2.put(query, m2.get(query)+1);
            }
            
        }
        
        
        // int[] sums = new int[sum+1];
//         Map<Integer, Integer> sums = new HashMap<>();
//         int count = 0;
        
        
//         int index = 0;
        
//         for (int i=0; i<nums.length; i++) {
//             count += nums[i];
//             while (index < count) {
//                 sums.put(index, i);
//                 index++;
//             }
//         }
        // int[] res = new int[queries.length];
//         for (int i=0; i<res.length; i++) {
//             if (queries[i] < sum) {
//                 res[i] = sums.get(queries[i]);
//             } else {
//                 res[i] = nums.length;
//             }
            
//         }
        return res;
    }
}