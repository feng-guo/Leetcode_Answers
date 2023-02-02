class Solution {
    Map<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();
        int index=0;
        for (char c: order.toCharArray()) {
            map.put(c, index);
            index++;
        }
        for (int i=0; i<words.length-1; i++) {
            if (!sorted(words[i], words[i+1])) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean sorted(String word1, String word2) {
        for (int i=0; i<Math.min(word1.length(), word2.length()); i++) {
            if (map.get(word1.charAt(i)) < map.get(word2.charAt(i))) {
                return true;
            } else if (word1.charAt(i) != word2.charAt(i)) {
                return false;
            }
        }
        return word1.length() <= word2.length();
    }
}