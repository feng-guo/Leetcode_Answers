class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int index = 0;
        while (index < Math.min(w1.length, w2.length)) {
            sb.append(w1[index]);
            sb.append(w2[index]);
            index++;
        }
        char[] w3;
        if (w1.length > w2.length) {
            w3 = w1;
        } else if (w2.length > w1.length) {
            w3 = w2;
        } else {
            return sb.toString();
        }
        for (int i=index; i<w3.length; i++) {
            sb.append(w3[i]);
        }
        return sb.toString();
    }
}