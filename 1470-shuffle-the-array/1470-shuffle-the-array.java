class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int i1 = 0;
        int i2 = n;
        for (int i=0; i<2*n; i++) {
            int j;
            if (i%2==0) {
                j=i1;
                i1++;
            } else {
                j=i2;
                i2++;
            }
            res[i] = nums[j];
        }
        return res;
    }
}