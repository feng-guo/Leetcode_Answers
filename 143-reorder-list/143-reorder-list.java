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
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode next = head;
        while (next != null) {
            length++;
            next = next.next;
        }
        
        ListNode[] nodes = new ListNode[length];
        next = head;
        for (int i=0; i<length; i++) {
            nodes[i] = next;
            next = next.next;
        }
        int start = 1;
        int end = length-1;
        next = head;
        for (int i=1; i<length; i++) {
            if (i%2 == 1) {
                next.next = nodes[end];
                end--;
            } else {
                next.next = nodes[start];
                start++;
            }
            next = next.next;
            if (i == length-1) {
                next.next = null;
            }
        }
    }
}