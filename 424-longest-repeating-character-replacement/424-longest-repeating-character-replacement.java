class Solution {
    public int characterReplacement(String s, int k) {
        // Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        
        Set<String> set = new HashSet<>();
        
        String current = "";
        int best = 0;
        int count = 0;
        boolean has_new = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while (has_new) {
            has_new = false;
            count = 0;
            current = "";
            pq = new PriorityQueue<>();
            int c_k = k;
            for (int i=0; i<s.length(); i++) {
                String c = s.substring(i, i+1);
                if (!has_new && set.add(c)) {
                    current = c;
                    count++;
                    has_new = true;
                } else if (!has_new || !c.equals(current)) {
                    pq.add(i);
                    if (c_k == 0) {
                        int last = pq.poll();
                        count = i-last;
                    } else {
                        c_k--;
                        count++;
                    }
                } else if (c.equals(current)) {
                    count++;
                }
                best = Math.max(best, count);
            }
        }
        
        
        return best;
        
    }
}