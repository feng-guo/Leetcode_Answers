class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        String res = "";
        for (String word: words) {
            String space = "";
            if (!res.equals("")) {
                space = " ";
            }
            res = word + space + res;
        }
        return res;
    }
}