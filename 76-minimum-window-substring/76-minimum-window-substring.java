class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counting = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            if (counting.containsKey(t.charAt(i))) {
                counting.put(t.charAt(i), counting.get(t.charAt(i)) + 1);
            } else {
                counting.put(t.charAt(i), 1);
            }
        }
        Map<Character, Integer> m = new HashMap<>(counting);
        Map<Character, Integer> extra = new HashMap<>();
        //Grow window until condition is satisfied, shrink until it is not satisfied
        int best_l = Integer.MAX_VALUE;
        String best = "";
        int lag = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (m.containsKey(c)) {
                if (m.get(c) == 1) {
                    m.remove(c);
                } else {
                    m.put(c, m.get(c) - 1);
                }
            } else if(counting.containsKey(c)) {
                if (extra.containsKey(c)) {
                    extra.put(c,extra.get(c) + 1);
                } else {
                    extra.put(c,1);
                }
            }
            while(m.isEmpty()) {
                if (s.substring(lag, i+1).length() < best_l) {
                    best = s.substring(lag, i+1);
                    best_l = best.length();
                }
                char c2 = s.charAt(lag);
                if (counting.containsKey(c2)) {
                    if (extra.containsKey(c2)) {
                        if (extra.get(c2) == 1) {
                            extra.remove(c2);
                        } else {
                            extra.put(c2, extra.get(c2) - 1);
                        }
                    } else if (!(m.containsKey(c2))) {
                        m.put(c2, 1);
                    } else {
                        m.put(c2, m.get(c2) + 1);
                    }
                }
                
                lag++;
            }
        }
        return best;
    }
}