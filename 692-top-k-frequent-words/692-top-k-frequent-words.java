class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        
        String[][] to_sort = new String[map.keySet().size()][2];
        int index =0 ;
        for (String key: map.keySet()) {
            to_sort[index][0] = key;
            to_sort[index][1] = map.get(key).toString();
            // System.out.println()
            index++;
        }
        
        Arrays.sort(to_sort, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                if (Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])) == 0) {
                    return a[0].compareTo(b[0]);
                } else {
                    return -Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
                }
            }
        });
        
        List<String> res = new ArrayList<>();
        
        for (int i=0; i<k; i++) {
            res.add(to_sort[i][0]);
        }
        
        return res;
    }
}