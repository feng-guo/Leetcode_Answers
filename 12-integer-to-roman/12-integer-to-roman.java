class Solution {
    public String intToRoman(int num) {
        String roman = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(500, "D");
        map.put(100, "C");
        map.put(50, "L");
        map.put(10, "X");
        map.put(5, "V");
        map.put(1, "I");
        int divisor = 1000;
        
        while (num != 0) {
            int smaller = divisor / 10;
            if (num >= divisor) {
                roman += map.get(divisor);
                num -= divisor;
            } else if (num >= (divisor - smaller)) {
                roman += map.get(smaller) + map.get(divisor);
                num -= (divisor - smaller);
            } else if (num >= divisor/2) {
                roman += map.get(divisor/2);
                num  -= (divisor/2);
            } else if (num >= (divisor/2) - smaller) {
                roman += map.get(smaller) + map.get(divisor/2);
                num  -= ((divisor/2) - smaller);
            } else {
                divisor = smaller;
            }
        }
        
        return roman;
    }
}