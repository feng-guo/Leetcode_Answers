class Solution {
    public int compress(char[] chars) {
        char current = chars[0];
        int count = 1;
        int index = 0;
        for (int i=1; i<chars.length; i++) {
            if (chars[i] != current) {
                char temp = chars[i];
                chars[index] = current;
                index++;
                //Write the number
                if (count > 1) {
                    String s = Integer.toString(count);
                    for (int j=0; j<s.length(); j++) {
                        chars[index] = s.charAt(j);
                        index++;
                    }
                }
                
                current = temp;
                count = 1;
            } else {
                count++;
            }
        }
        chars[index] = current;
                index++;
        if (count > 1) {
                    String s = Integer.toString(count);
                for (int j=0; j<s.length(); j++) {
                    chars[index] = s.charAt(j);
                    index++;
                }
            }
        
        return index;
    }
}