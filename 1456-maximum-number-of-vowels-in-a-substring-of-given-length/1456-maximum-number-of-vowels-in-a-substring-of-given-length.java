class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int lag = 0;
        int count = 0;
        char[] char_array = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i=0; i<k; i++) {
            if (vowels.contains(char_array[i])) {
                count++;
            }
        }
        max = count;
        for (int i=k; i<char_array.length; i++) {
            if (vowels.contains(char_array[lag])) {
                count--;
            }
            lag++;
            if (vowels.contains(char_array[i])) {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}