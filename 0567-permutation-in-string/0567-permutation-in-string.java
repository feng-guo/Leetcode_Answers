class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i=0; i<s1.length(); i++) {
            if (m.containsKey(s1.charAt(i))) {
                m.put(s1.charAt(i), m.get(s1.charAt(i)) + 1);
            } else {
                m.put(s1.charAt(i), 1);
            }
        }
        Map<Character, Integer> counting_m = new HashMap<>(m);
        
        int lag = 0;
        int count = s1.length();
        for (int i=0; i<s2.length(); i++) {
           if (m.containsKey(s2.charAt(i))) {
               int value = m.get(s2.charAt(i));
               if (value == 1) {
                   m.remove(s2.charAt(i));
               } else {
                   m.put(s2.charAt(i), value-1);
               }
               count--;
           } else if (counting_m.containsKey(s2.charAt(i))) {
               //have to loop until i can put it in
               while(!m.containsKey(s2.charAt(i))) {
                   if (counting_m.containsKey(s2.charAt(lag))) {
                       if (!(m.containsKey(s2.charAt(lag)))) {
                           m.put(s2.charAt(lag), 1);
                           count++;
                       } else if (m.get(s2.charAt(lag)) != counting_m.get(s2.charAt(lag))) {
                           m.put(s2.charAt(lag), m.get(s2.charAt(lag)) + 1);
                           count++;
                       } 
                    } else {
                        //This shouldn't happen
                    }
                   lag++;
               }
               int value = m.get(s2.charAt(i));
               if (value == 1) {
                   m.remove(s2.charAt(i));
               } else {
                   m.put(s2.charAt(i), value-1);
               }
               count--;
           } else {
               //have to reset
               lag = i;
               count = s1.length();
               m = new HashMap<>(counting_m);
           }
            if (m.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}