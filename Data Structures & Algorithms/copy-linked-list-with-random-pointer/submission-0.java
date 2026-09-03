/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // Pass 1: create all new nodes (val only)
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // Pass 2: wire up next and random using the map
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);     // null maps to null automatically
            map.get(cur).random = map.get(cur.random); // null maps to null automatically
            cur = cur.next;
        }

        return map.get(head);
    }
}