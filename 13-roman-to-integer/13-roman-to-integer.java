class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] c = s.toCharArray();
        for (int i=0; i<c.length; i++) {
            if (c[i] == 'I' && i != c.length-1 && (c[i+1] == 'V' || c[i+1] == 'X')) {
                sum -= map.get(c[i]);
            } else if (c[i] == 'X' && i != c.length-1 && (c[i+1] == 'L' || c[i+1] == 'C')) {
                sum -= map.get(c[i]);
            } else if (c[i] == 'C' && i != c.length-1 && (c[i+1] == 'D' || c[i+1] == 'M')) {
                sum -= map.get(c[i]);
            } else {
                sum += map.get(c[i]);
            }
        }
        return sum;
    }
}