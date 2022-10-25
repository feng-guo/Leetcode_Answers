class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String string1 = "";
        String string2 = "";
        for (String str: word1) {
            string1 += str;
        }
        for (String str: word2) {
            string2 += str;
        }
        return string1.equals(string2);
    }
}