class WordDictionary {
    Map<Character, WordDictionary> map;
    Set<Character> end;
    
    public boolean startsWith(String prefix) {    
        if ("".equals(prefix)) {
            return true;
        } 
        char c = prefix.charAt(0);
        if (map.containsKey(c)) {
            return map.get(c).startsWith(prefix.substring(1));
        } else {
            return false;
        }
    }
    
    
    public WordDictionary() {
        map = new HashMap<>();
        end = new HashSet<>();
    }
    
    public void addWord(String word) {
        if (word.equals("")) {
            return;
        }
        char c = word.charAt(0);
        if (map.containsKey(c)) {
            map.get(c).addWord(word.substring(1));
        } else {
            WordDictionary wd = new WordDictionary();
            wd.addWord(word.substring(1));
            map.put(c, wd);
        }
        if (word.length() == 1) {
            end.add(c);
        }
    }
    
    public boolean search(String word) {
        char c = word.charAt(0);
        if (word.length() == 1) {
            if (c=='.') {
                return !end.isEmpty();
            }
            return end.contains(c);
        } else if (map.containsKey(c)) {
            return map.get(c).search(word.substring(1));
        } else if (c == '.' && !map.isEmpty()) {
            for (char m: map.keySet()) {
                if (map.get(m).search(word.substring(1))) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */