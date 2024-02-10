class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i=0; i<s.length(); i++) {
            count++;
            int distance = 1;
            while(i-distance > -1 && i+distance<s.length()) {
                if (s.charAt(i-distance) == s.charAt(i+distance)) {
                    count++;
                    distance++;
                } else {
                    break;
                }
            }
            distance = 1;
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                count++;
                while(i-distance > -1 && i+distance+1<s.length()) {
                    if (s.charAt(i-distance) == s.charAt(i+distance+1)) {
                        count++;
                        distance++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}