class LRUCache {

    int capacity;
    int currSize;
    HashMap<Integer, Node> nodeMap;
    Node head;
    Node tail;

    public LRUCache(int c) {
        capacity = c;
        currSize = 0;
        nodeMap = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);
        removeNode(node);
        addToHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);

            node.val = value;
            removeNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            addToHead(node);
            currSize += 1;

            if (currSize > capacity) {
                int removeKey = removeFromTail();
                nodeMap.remove(removeKey);
            }
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private int removeFromTail() {
        Node node = tail.prev;
        removeNode(node);

        return node.key;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int k, int v) {
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */