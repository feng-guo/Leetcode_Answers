class Solution {
    public String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length());
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int carry=0;
        String res = "";
        for (int i=0; i<max; i++) {
            int ad = ac.length-i>0?ac[a.length()-1-i]-48:0;
            int bd = bc.length-i>0?bc[b.length()-1-i]-48:0;
            res = ((ad^bd)^carry) + res;
            carry = (ad & bd) | (carry & bd) | (carry & ad);
        }
        if (carry==1) {
            res = "1" + res;
        }
        return res;
    }
}