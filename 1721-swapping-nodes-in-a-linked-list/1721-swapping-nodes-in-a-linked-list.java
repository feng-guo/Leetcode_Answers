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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        ListNode front = null;
        while (current != null) {
            count++;
            if (count == k) {
                front = current;
            }
            current = current.next;
        }
        current = head;
        for (int i=0; i<count-k; i++) {
            current = current.next;
        }
        int temp = current.val;
        current.val = front.val;
        front.val = temp;
        return head;
    }
}