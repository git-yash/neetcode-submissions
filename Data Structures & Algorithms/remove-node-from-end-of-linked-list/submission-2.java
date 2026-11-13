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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;

        while(curr != null) {
            curr = curr.next;
            length++;
        }

        if(length == n) {return head.next;}

        ListNode nth = head;
        ListNode prev = head;
        for(int i = 0; i < length - n; i++) {
            if(i == length - n - 1) {
                prev = nth;
            }
            nth = nth.next;
        }

        prev.next = nth.next;

        return head;
    }
}
