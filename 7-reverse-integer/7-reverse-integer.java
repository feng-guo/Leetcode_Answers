class Solution {
    public int reverse(int x) {
        String itos = Integer.toString(x);
        boolean negative = false;
        if (itos.charAt(0) == '-') {
            negative = true;
        }
        String temp = "";
        for (int i=itos.length()-1; i>-1; i--) {
            if (itos.charAt(i) != '-') {
                temp += itos.charAt(i);
            }
        }
        int res = 0;
        try {
            res = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            return 0;
        }
        if (negative) {
            res *= -1;
        }
        return res;
    }
}