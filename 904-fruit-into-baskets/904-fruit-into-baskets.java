class Solution {
    public int totalFruit(int[] fruits) {
        int a = -1;
        int length_a = 0;
        int b = -1;
        int length_b = 0;
        
        int best = Integer.MIN_VALUE;
        int current = 0;
        for (int i=0; i<fruits.length; i++) {
            if (a == -1 || fruits[i] == a){
                current++;
                length_a++;
                length_b = 0;
                a = fruits[i];
            } else if (b == -1 || fruits[i] == b){
                current++;
                length_b++;
                length_a = 0;
                b = fruits[i];
            } else {
                if (length_b != 0) {
                    current = length_b+1;
                    length_b = 0;
                    a = fruits[i];
                    length_a = 1;
                } else {
                    current = length_a+1;
                    length_a = 0;
                    b = fruits[i];
                    length_b = 1;
                }
            }
            if (current > best) {
                best = current;
            }
        }
        return best;
    }
}