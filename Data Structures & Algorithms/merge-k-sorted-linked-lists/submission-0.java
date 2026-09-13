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
        if (lists == null || lists.length == 0) return null;

        List<ListNode> curr = new ArrayList<>(Arrays.asList(lists));

        while (curr.size() > 1) {
            List<ListNode> merged = new ArrayList<>();

            for (int i = 0; i < curr.size(); i += 2) {
                ListNode l1 = curr.get(i);
                ListNode l2 = (i + 1 < curr.size()) ? curr.get(i + 1) : null;
                merged.add(helper(l1, l2));
            }

            curr = merged;
        }

        return curr.get(0);
    }

    private ListNode helper(ListNode start, ListNode end){

        ListNode dummy = new ListNode(0);

       ListNode tail = dummy;

        while(start != null && end != null){

              if(start.val <= end.val){
                tail.next = start;
                start = start.next;

              }  
              else{

                tail.next = end;
                end = end.next;
              }

             tail =  tail.next;
        }

        
      tail.next = (start != null) ? start : end;

      return dummy.next ;
        
    }
}
