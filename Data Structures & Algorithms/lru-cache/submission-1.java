class LRUCache {
    // Node for our doubly linked list — represents one cache entry
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;   // key -> Node, gives O(1) lookup
    private Node head, tail;          // dummy sentinels: head side = most recently used, tail side = least recently used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // dummy sentinel nodes so we never have to null-check the ends of the list
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Unlink a node from wherever it currently sits in the list.
    // Works because doubly linked list nodes know their own prev/next,
    // so no need to search for neighbors — O(1).
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node right after head, i.e. mark it as most recently used.
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        // key not present at all -> cache miss
        if (!map.containsKey(key)) {
            return -1;
        }

        // key found: this counts as "using" it, so move it to most-recently-used position
        Node node = map.get(key);
        remove(node);          // unlink from current spot
        insertAtFront(node);   // re-insert at front (most recent)
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Case A: key already exists -> update value, then move to front (most recent)
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        } else {
            // Case B: brand new key -> create node, add to map, insert at front
            Node node = new Node(key, value);
            map.put(key, node);
            insertAtFront(node);

            // If we've exceeded capacity, evict the least recently used node,
            // which always sits right before the tail sentinel.
            if (map.size() > capacity) {
                Node lru = tail.prev;
                remove(lru);          // unlink from linked list
                map.remove(lru.key);  // also remove from map, or we'd have a stale reference
            }
        }
    }
}