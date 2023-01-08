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
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listsList = new ArrayList<>(Arrays.asList(lists));
        if (listsList.size() == 0) {
            return null;
        }
        while (listsList.size() > 1) {
            ListNode head1 = listsList.remove(0);
            ListNode head2 = listsList.remove(0);
            if (head1 == null && head2 == null) {
                continue;
            } else if (head1 == null) {
                listsList.add(head2);
                continue;
            } else if (head2 == null) {
                listsList.add(head1);
                continue;
            }
            ListNode head;
            if (head1.val <= head2.val) {
                head = head1;
                head1 = head1.next;
            } else {
                head = head2;
                head2 = head2.next;
            }
            ListNode next = head;
            while (head1 != null && head2 != null) {
                if (head2 == null || (head1.val <= head2.val)) {
                    next.next = head1;
                    head1 = head1.next;
                } else {
                    next.next = head2;
                    head2 = head2.next;
                }
                next = next.next;
            }
            if (head1 != null) {
                next.next = head1;
            } else if (head2 != null) {
                next.next = head2;
            }
            listsList.add(head);
        }
        
        return listsList.isEmpty() ? null: listsList.get(0);
    }
}