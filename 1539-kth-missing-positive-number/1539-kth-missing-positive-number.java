class Solution {
    public int findKthPositive(int[] arr, int k) {
        int last = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]-last > k) {
                //count within k
                return last + k;
            } else {
                k -= arr[i] - last - 1;
                last = arr[i];
            }
        }
        return last + k;
    }
}