public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long temp = Integer.toUnsignedLong(n);
        long max = 1;
        int shifts = 0;
        while (max <= temp) {
            max  = max << 1;
            // System.out.println(max);
            shifts++;
        }
        // System.out.println("done");
        int index = 0;
        int count = 0;
        while (index < shifts) {
            count += (temp & 1) == 1 ? 1: 0;
            temp >>= 1;
            index++;
        }
        return count;
    }
}