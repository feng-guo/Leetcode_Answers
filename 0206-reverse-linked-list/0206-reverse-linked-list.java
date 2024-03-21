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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        if (current == null) {
            return null;
        }
        ListNode next = head.next;
        ListNode prev = null;
        while (next != null) {
            ListNode temp = next.next;
            
            next.next = current;
            current.next = prev;
            prev = current;
            current = next;
            next = temp;
        }
        return current;
    }
}