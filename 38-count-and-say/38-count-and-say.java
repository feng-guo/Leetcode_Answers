class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n-1);
        
        int current = -1;
        int count = 0;
        String return_string = "";
        for (char c: prev.toCharArray()) {
            int ci =  Character.getNumericValue(c);
            if (ci != current) {
                if (current !=-1) {
                    return_string += Integer.toString(count) + Integer.toString(current);   
                }
                count = 0;
                current = ci;
            }
            count++;
        }
        return_string += Integer.toString(count) + Integer.toString(current);
        return return_string;
    }
}