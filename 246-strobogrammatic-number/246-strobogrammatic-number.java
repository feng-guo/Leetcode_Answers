class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        char[] ca = num.toCharArray();
        for (int i=ca.length-1; i>-1; i--) {
            if (ca[i] == '6') {
                sb.append("9");
            } else if (ca[i] == '9') {
                sb.append("6");
            } else if (ca[i] == '8') {
                sb.append("8");
            } else if (ca[i] == '0') {
                sb.append("0");
            } else if (ca[i] == '1') {
                sb.append("1");
            } else {
                return false;
            }
        }
        return num.equals(sb.toString());
    }
}