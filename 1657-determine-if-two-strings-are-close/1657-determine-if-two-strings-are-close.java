class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> word1_map = new HashMap<>();
        Map<Character, Integer> word2_map = new HashMap<>();
        
        for (Character c: word1.toCharArray()) {
            if (word1_map.containsKey(c)) {
                word1_map.put(c, word1_map.get(c)+1);
            } else {
                word1_map.put(c, 1);
            }
        }
        
        for (Character c: word2.toCharArray()) {
            if (word2_map.containsKey(c)) {
                word2_map.put(c, word2_map.get(c)+1);
            } else {
                word2_map.put(c, 1);
            }
        }
        
        if (word1_map.keySet().size() != word2_map.keySet().size()) {
            return false;
        }
        
        Map<Integer, Integer> word1_c_occ = new HashMap<>();
        Map<Integer, Integer> word2_c_occ = new HashMap<>();
        
        for (Character c: word1_map.keySet()) {
            if (!word2_map.containsKey(c)) {
                return false;
            } else {
                int i1 = word1_map.get(c);
                int i2 = word2_map.get(c);
                if (word1_c_occ.containsKey(i1)) {
                    word1_c_occ.put(i1, word1_c_occ.get(i1) +1);
                } else {
                    word1_c_occ.put(i1, 1);
                } 
                if (word2_c_occ.containsKey(i2)) {
                    word2_c_occ.put(i2, word2_c_occ.get(i2) +1);
                } else {
                    word2_c_occ.put(i2, 1);
                }
            }
        }
        
        if (word1_c_occ.keySet().size() != word2_c_occ.keySet().size()) {
            return false;
        }
        
        for (Integer i: word1_c_occ.keySet()) {
            if (!word2_c_occ.containsKey(i) || word2_c_occ.get(i) != word1_c_occ.get(i)) {
                return false;
            }
        }
        
        return true;
    }
}