/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode intersect = findIntersect(head);
        if (intersect == null) {
            return null;
        } else {
            return findStart(head, intersect);
        }
    }
    
    public ListNode findIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }
    
    public ListNode findStart(ListNode head, ListNode intersect) {
        while (head != intersect) {
            head = head.next;
            intersect = intersect.next;
        }
        return head;
    }
}