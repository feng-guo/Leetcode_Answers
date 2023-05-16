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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode list1 = head;
        ListNode list2 = head.next;
        ListNode list1head = list1;
        ListNode list2head = list2;
        if (list2 == null) {
            return head;
        }
        ListNode current = list2.next;
        boolean flag = false;
        while (current != null) {
            if (flag) {
                list2.next = current;
                list2 = list2.next;
            } else {
                list1.next = current;
                list1 = list1.next;
            }
            flag = !flag;
            current = current.next;
        }
        list1.next = null;
        list2.next = null;
        
        list1 = list1head;
        list2 = list2head;
        
        
        head = list2head;
        current = head;
        list2 = list2.next;
        
        while (list2 != null) {
            current.next = list1;
            current = current.next;
            list1 = list1.next;
            
            current.next = list2;
            current = current.next;
            list2 = list2.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        return head;
    }
}