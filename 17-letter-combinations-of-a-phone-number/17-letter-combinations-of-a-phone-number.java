class Solution {
    Map<Character, List<String>> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList();
        }
        map = new HashMap<>();
        map.put('2', Arrays.asList(new String[] { "a", "b", "c" }));
        map.put('3', Arrays.asList(new String[] { "d", "e", "f" }));
        map.put('4', Arrays.asList(new String[] { "g", "h", "i" }));
        map.put('5', Arrays.asList(new String[] { "j", "k", "l" }));
        map.put('6', Arrays.asList(new String[] { "m", "n", "o" }));
        map.put('7', Arrays.asList(new String[] { "p", "q", "r", "s" }));
        map.put('8', Arrays.asList(new String[] { "t", "u", "v" }));
        map.put('9', Arrays.asList(new String[] { "w", "x", "y", "z" }));
        res = new ArrayList<>();
        mutate(digits, 0, new StringBuilder());
        return res;
    }
    
    public void mutate(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i=0; i<map.get(digits.charAt(index)).size(); i++) {
            StringBuilder copy = new StringBuilder(sb);
            mutate(digits, index+1, copy.append(map.get(digits.charAt(index)).get(i)));
        }
    }
}