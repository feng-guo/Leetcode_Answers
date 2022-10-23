class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int reverse = x%10;
        x /= 10;
        while (x > 0) {
            reverse = (reverse*10) + x%10;
            x /= 10;
        }
        return reverse == temp && temp >= 0;
    }
}