class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int modulo = numRows + (numRows-2);
        String[] strings = new String[numRows];
        String res = "";
        for (int i=0; i<strings.length; i++) {
            strings[i] = "";
        }
        
        int prev = 0;
        
        char[] c = s.toCharArray();
        for (int i=0; i<s.length(); i++) {
            if (i%modulo<numRows) {
                prev = i%modulo;
                strings[prev] += c[i];
            } else {
                prev--;
                strings[prev] += c[i];
            }
        }
        
        for (String str: strings) {
            // System.out.println(str);
            res += str;
        }
        
        return res;
    }
}