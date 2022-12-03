class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> ci = new HashMap<>();
        Map<Integer, Set<Character>> ic = new HashMap<>();
        int best = 0;
        
        for (char c: s.toCharArray()) {
            if (ci.containsKey(c)) {
                ci.put(c, ci.get(c)+1);
            } else {
                ci.put(c, 1);
            }
            int count = ci.get(c);
            best = Math.max(best, count);
            if (count > 1) {
                ic.get(count-1).remove(c);
            }
            if (ic.containsKey(count)) {
                ic.get(count).add(c);
            } else {
                Set<Character> set = new HashSet<>();
                set.add(c);
                ic.put(count, set);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=best; i>0; i--) {
            if (ic.containsKey(i)) {
                for (Character c: ic.get(i)) {
                    for (int j=0; j<i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}