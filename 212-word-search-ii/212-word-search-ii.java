class Solution {
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

        public Trie contains(char c) {
            return map.get(c);
        }
        
        public boolean containsWord(char c) {
            return end.contains(c);
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
    
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> set = new HashSet<>();
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                explore(board, set, visited, trie, i, j, "");
            }
        }
        
        
        List<String> list = new ArrayList<>(set);
        
        return list;
    }
    
    public void explore(char[][] board, Set<String> set, boolean[][] visited, Trie words, int x, int y, String str) {
        visited[x][y] = true;
        char c = board[x][y];
        Trie trie = words.contains(c);
        if (trie != null) {
            str += c;
            if (words.containsWord(c)) {
                set.add(str);
            }
            
            if (x!=0 && !visited[x-1][y]) {
                explore(board, set, visited, trie, x-1, y, str);
            }
            if (x!=board.length-1 && !visited[x+1][y]) {
                explore(board, set, visited, trie, x+1, y, str);
            }
            if (y!=0 && !visited[x][y-1]) {
                explore(board, set, visited, trie, x, y-1, str);
            }
            if (y!=board[0].length-1 && !visited[x][y+1]) {
                explore(board, set, visited, trie, x, y+1, str);
            }
        }
        
        visited[x][y] = false;
    }
    
    
}