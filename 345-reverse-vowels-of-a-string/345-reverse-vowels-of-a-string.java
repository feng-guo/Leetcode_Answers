class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        String vowels = "";
        for (int i=0; i<s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                vowels = s.charAt(i) + vowels;
            } 
        }
        int count = 0;
        String res= "";
        for (int i=0; i<s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res += vowels.charAt(count);
                count++;
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}