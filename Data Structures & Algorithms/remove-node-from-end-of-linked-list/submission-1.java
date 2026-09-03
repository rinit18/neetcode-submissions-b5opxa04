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

        // 1. Create a dummy node to seamlessly handle edge cases (e.g., deleting head)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // 2. Advance fast by n + 1 steps to create the exact window gap
        for(int i = 0; i <= n ; i++){

            fast = fast.next;
        }

        // 3. Move both pointers together until fast hits the end (null)
        while(fast != null){

            slow = slow.next;
            fast = fast.next ;


        }
         
         // 4. Delete the target node by skipping it
        slow.next = slow.next.next;

        // Return the actual head of the list
        return dummy.next;

    }
}
