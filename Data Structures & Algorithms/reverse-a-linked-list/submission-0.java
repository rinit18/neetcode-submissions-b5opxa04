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
         ListNode prev = null;
            ListNode curr = head;

            while(curr != null){

                ListNode nextTemp = curr.next; // save next
                curr.next = prev;              // reverse pointer
                prev = curr;                   // advance prev
                curr = nextTemp;
            }

            return prev;

    }
}
