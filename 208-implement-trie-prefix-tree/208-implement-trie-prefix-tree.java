class Trie {
    Map<Character, Trie> map;
    Set<Character> end;

    public Trie() {
        map = new HashMap<>();
        end = new HashSet<>();
    }
    
    public void insert(String word) {
        if (word.equals("")) {
            return;
        }
        char c = word.charAt(0);
        if (map.containsKey(c)) {
            map.get(c).insert(word.substring(1));
        } else {
            Trie trie = new Trie();
            trie.insert(word.substring(1));
            map.put(c, trie);
        }
        if (word.length() == 1) {
            end.add(c);
        }
    }
    
    public boolean search(String word) {
        char c = word.charAt(0);
        if (word.length() == 1) {
            return end.contains(c);
        } else if (map.containsKey(c)) {
            return map.get(c).search(word.substring(1));
        } else {
            return false;
        }
    }
    
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
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */