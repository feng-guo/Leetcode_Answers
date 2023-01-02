class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m+n];
        int i1 = 0;
        int i2 = 0;
        for (int i=0; i<nums3.length; i++) {
            if (i1 != m && (i2 == n || nums1[i1] <= nums2[i2])) {
                nums3[i] = nums1[i1];
                i1++;
            } else {
                nums3[i] = nums2[i2];
                i2++;
            }
        }
        for (int i=0; i<nums3.length; i++) {
            nums1[i] = nums3[i];
        }
    }
}