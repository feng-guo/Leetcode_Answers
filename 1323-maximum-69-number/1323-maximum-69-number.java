class Solution {
    public int maximum69Number (int num) {
        String string = Integer.toString(num);
        for (int i=0; i<string.length(); i++) {
            if (string.charAt(i)=='6') {
                String best = string.substring(0, i) + '9' + string.substring(i+1);
                return Integer.parseInt(best);
            }
        }
        return num;
    }
}