class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int count = 0;
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        while (k!=0 || count<num.length) {
            int sum = count<num.length?num[num.length-1-count]+k%10+carry:k%10+carry;
            carry = sum/10;
            res.add(sum%10);
            k/=10;
            count++;
        }
        if (carry != 0) {
            res.add(carry);
        }
        Collections.reverse(res);
        return res;
    }
}