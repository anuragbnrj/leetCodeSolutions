class LRUCache {
    int capacity;
    Map<Integer, Node> dic;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!dic.containsKey(key)) {
            return -1;
        }

        Node node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (dic.containsKey(key)) {
            Node nodeToBeRemoved = dic.get(key);
            dic.remove(nodeToBeRemoved.key);
            remove(nodeToBeRemoved);
        }

        Node newNode = new Node(key, value);
        add(newNode);
        dic.put(key, newNode);

        if (dic.size() > capacity) {
            Node nodeToBeRemoved = tail.prev;
            dic.remove(nodeToBeRemoved.key);
            remove(tail.prev);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node() {
            val = 0;
            prev = null;
            next = null;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
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