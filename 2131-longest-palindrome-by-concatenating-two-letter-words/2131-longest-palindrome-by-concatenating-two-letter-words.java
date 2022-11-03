class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        
        Set<String> two = new HashSet<>();
        
        int count = 0;
        
        for (String word: words) {
            String backwards = word.charAt(1) + "" + word.charAt(0);
            if (map.containsKey(backwards)) {
                count += 4;
                int remaining = map.get(backwards) - 1;
                if (remaining == 0) {
                    map.remove(backwards);
                } else {
                    map.put(backwards, remaining);
                }
            } else {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
                if (word.charAt(0) == word.charAt(1)) {
                    two.add(word);
                }
            }
        }
        
        for (String word: two) {
            if (map.containsKey(word)) {
                count += 2;
                break;
            }
        }
        
        return count;
    }
}