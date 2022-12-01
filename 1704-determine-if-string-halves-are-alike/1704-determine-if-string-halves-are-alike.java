class Solution {
    public boolean halvesAreAlike(String s) {
        int count1=0;
        int count2=0;
        char[] arr = s.toCharArray();
        Set<Character> v = new HashSet<>();
        v.add('a');
        v.add('e');
        v.add('i');
        v.add('o');
        v.add('u');
        v.add('A');
        v.add('E');
        v.add('I');
        v.add('O');
        v.add('U');
        for (int i=0; i<(s.length()/2); i++) {
            char fh = arr[i];
            char sh = arr[s.length()-1-i];
            if (v.contains(fh)) {
                count1++;
            }
            if (v.contains(sh)) {
                count2++;
            }
        }
        return count1==count2;
    }
}