class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        long count = 0;
        for (int num: nums) {
            if (num == 0) {
                count++;
            } else if (num != 0 && count != 0) {
                sum += ((1+count) * count)/2;
                count = 0;
            }
        }
        if (count != 0) {
                sum += ((1+count) * count)/2;
                count = 0;
            }
        return sum;
    }
}