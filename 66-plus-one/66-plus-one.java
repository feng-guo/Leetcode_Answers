class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length-1;
        while (carry == 1) {
            if (digits[index] == 9) {
                digits[index] = 0;
                if (index == 0) {
                    int[] overflow = new int[digits.length+1];
                    overflow[0] = 1;
                    for (int i=1; i<overflow.length; i++) {
                        overflow[i] = digits[i-1];
                    }
                    return overflow;
                }
            } else {
                digits[index]++;
                carry = 0;
            }
            index--;
        }
        
        return digits;
    }
}