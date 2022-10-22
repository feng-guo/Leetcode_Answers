class Solution {
    public int countVowelSubstrings(String word) {
        int j = 0, k = 0, vow = 0, cnt = 0;

    HashMap < Character, Integer > map = new HashMap < > ();
    map.put('a', 0);
    map.put('e', 0);
    map.put('i', 0);
    map.put('o', 0);
    map.put('u', 0);

    for (int i = 0; i < word.length(); ++i) {
        if (map.get(word.charAt(i)) != null) {
            map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
            if ((int) map.get(word.charAt(i)) == 1) {
                ++vow;
            }
            while (vow == 5) {
                map.put(word.charAt(k), map.get(word.charAt(k)) - 1);
                if ((int) map.get(word.charAt(k)) == 0) {
                    --vow;
                }
                k++;
            }
            cnt = cnt + (k - j);
        } else {
            map.forEach((k1, v) -> {
                map.put(k1, 0);
            });
            vow = 0;
            j = k = i + 1;
        }
    }
    return cnt;
//         Map<Character, Integer> vowels = new HashMap<>();
        

//         vowels.put('a', 0);
//         vowels.put('e', 0);
//         vowels.put('i', 0);
//         vowels.put('o', 0);
//         vowels.put('u', 0);
        
//         String check = "";
//         int count = 0;
//         for (int i=0; i<word.length(); i++) {
//             Character c = word.charAt(i);
//             if (!vowels.containsKey(c)) {
//                 //Loop through
//                 // if (hasAllVowels(vowels)) {
//                 //     count--;
//                 // }
//                 while (hasAllVowels(vowels)) {
//                     char remove = check.charAt(0);
//                     vowels.put(remove, vowels.get(remove) - 1);
//                     check = check.substring(1);
//                     if (hasAllVowels(vowels)) {
//                         System.out.println("While: " +check);
//                         count++;
//                     }
//                 }
//                 check = "";
//                 vowels.put('a', 0);
//                 vowels.put('e', 0);
//                 vowels.put('i', 0);
//                 vowels.put('o', 0);
//                 vowels.put('u', 0);
//             } else {
//                 vowels.put(c, vowels.get(c) + 1);
//                 check += c;
//                 if (hasAllVowels(vowels)) {
//                     System.out.println("Else: " +check);
//                     count++;
//                 }
//             }
//         }
//         return count;
    }
    
    // public boolean hasAllVowels(Map<Character, Integer> vowels) {
    //     return vowels.get('a') > 0 && vowels.get('e') > 0 && vowels.get('i') > 0 && vowels.get('o') > 0 && vowels.get('u') > 0;
    // }
}