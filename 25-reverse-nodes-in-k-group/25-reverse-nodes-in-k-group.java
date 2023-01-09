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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length =0 ;
        ListNode next = head;
        while (next != null) {
            length++;
            next = next.next;
        }
        ListNode[] array = new ListNode[length];
        next = head;
        for (int i=0; i<length; i++) {
            array[i] = next;
            next = next.next;
        }
        head = array[k-1];
        for (int i=0; i<length/k*k; i++) {
            if (i%k == 0) {
                if (i+2*k <= length) {
                    array[i].next = array[i+2*k-1];
                } else if (i+k < length) {
                    array[i].next = array[i+k];
                } else {
                    array[i].next = null;
                }
            } else {
                array[i].next = array[i-1];
            }
        }
        return head;
        
        
        // return head;
        
//         List<ListNode> list = new ArrayList<>();
        
//         for (int i=0; i<length/k; i++) {
            
//             for (int j=0; j<k; j++) {
//                 if (i==0 && j==0) {
//                     head = array[k-1];
//                 }
//                 if (k*(i+1)-j-1 == 0) {
//                     array[k*(i+1)-j-1].next = null;
//                 } else {
//                     array[k*(i+1)-j-1].next = array[(k*i+1)-j-2];  
//                 }
//             }
//             list.add(array[k*(i+1)-1]);
//         }
//         if (length/k*k != length) {
//             list.add(array[length/k*k]);
//         }
        
    }
}