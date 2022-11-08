class Solution {
    public String makeGood(String s) {
        boolean bad = false;
        String t = "";
        for (int i=0; i<s.length(); i++) {
            if (!t.equals("")) {
                int prev = t.length()-1;
                char check = t.charAt(prev);
                char current = s.charAt(i);
                if (current != check + 32 && current != check - 32) {
                    t += current;
                } else {
                    t = t.substring(0, prev);
                }
            } else {
                t += s.charAt(i);
            }
        }
        return t;                                                                                                                               
    }
}