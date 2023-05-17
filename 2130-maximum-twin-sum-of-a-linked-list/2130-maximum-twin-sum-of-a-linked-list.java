/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode current = head;
        int[] sum;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        sum = new int[count/2];
        current = head;
        for (int i=0; i<count/2; i++) {
            sum[i] = current.val;
            current = current.next;
        }
        int max = 0;
        for (int i=0; i<count/2; i++) {
            sum[count/2-1-i] += current.val;
            max = Integer.max(max, sum[count/2-1-i]);
            current = current.next;
        }
        return max;
    }
}