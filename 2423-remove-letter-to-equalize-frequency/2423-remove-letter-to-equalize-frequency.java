class Solution {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Integer, Integer> freq_freq = new HashMap<>();
        
        for (char c: word.toCharArray()){
            if (!freq.containsKey(c)) {
                freq.put(c, 1);
            } else {
                freq.put(c, freq.get(c) + 1);
            }
        }
        
        if (freq.keySet().size() == 1) {
            return true;
        }
        
        for (Character c: freq.keySet()) {
            if (!freq_freq.containsKey(freq.get(c))) {
                freq_freq.put(freq.get(c), 1);
            } else {
                freq_freq.put(freq.get(c), freq_freq.get(freq.get(c)) + 1);
            }
        }
        
        
        if (freq_freq.keySet().size() > 2) {
            return false;
        } else if (freq_freq.keySet().size() == 1) {
            for (Integer i: freq_freq.keySet()) {
                return i == 1;
            }
            return false;
        } else {
            List<Integer> list = new ArrayList<>();
            
            for (Integer i: freq_freq.keySet()) {
                list.add(i);
                list.add(freq_freq.get(i));
            }
            
            if ( (Math.abs(list.get(0) - list.get(2)) == 1) && ( (list.get(0) > list.get(2) && list.get(1) == 1) || (list.get(2) > list.get(0) && list.get(3) == 1))) {
                return true;
            }
            
            if ( list.get(0) == 1 && list.get(1) == 1 || list.get(2) == 1 && list.get(3) == 1 ) {
                return true;
            }
            
            return false;
        }
    }
}