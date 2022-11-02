class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        
        for (String g: bank) {
            set.add(g); 
        }
        
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        
        q.add(start);
        map.put(start, 0);
        
        while (!q.isEmpty()) {
            String s = q.poll();
            if (s.equals(end)) {
                return map.get(s);
            }
            Set<String> not_used = new HashSet<>(set);
            
            for(String str: set) {
                boolean one_diff = false;
                boolean add = true;
                for (int i=0; i<str.length(); i++) {
                    if (!one_diff && str.charAt(i) != s.charAt(i)) {
                        one_diff = true;
                    } else if (str.charAt(i) != s.charAt(i)) {
                        add = false;
                    }
                }
                
                if (one_diff && add) {
                    map.put(str, map.get(s) + 1);
                    q.add(str);
                    not_used.remove(str);
                }
            }
            
            set = not_used;
        }
        
        return -1;
        
    }
}