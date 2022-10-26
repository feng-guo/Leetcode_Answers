class Solution {
    public boolean isHappy(int n) {
        Set<Integer> numbers = new HashSet<>();
        while(true)  {
            int sum = 0;
            while (n > 0) {
                sum += ((n%10) * (n%10));
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else if (!numbers.add(sum)) {
                return false;
            }
            n = sum;
        }
        
    }
}