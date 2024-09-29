class AllOne {
    private Node head;
    private Node tail;
    private Map<String, Integer> freq;
    private Map<String, Node> keyNodeMapping;

    public AllOne() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        freq = new HashMap<>();
        keyNodeMapping = new HashMap<>();
    }
    
    public void inc(String key) {
        if (!freq.containsKey(key)) {
            freq.put(key, 1);
            if (head.next == tail || head.next.keys.size() > 0) {
                addNodeAfter(new Node(), head);
            }
            head.next.keys.add(key);
            keyNodeMapping.put(key, head.next);
        } else {
            int count = freq.get(key);
            freq.put(key, count + 1);
            Node currNode = keyNodeMapping.get(key);
            Node nextNode = currNode.next;
            if (nextNode == tail || nextNode.keys.size() > 0) {
                addNodeAfter(new Node(), currNode);
                nextNode = currNode.next;
            }
            moveKey(key, currNode, nextNode);
        }
    }
    
    public void dec(String key) {
        if (!freq.containsKey(key)) return;
        
        int count = freq.get(key);
        Node currNode = keyNodeMapping.get(key);
        
        if (count == 1) {
            freq.remove(key);
            removeKeyFromNode(key, currNode);
        } else {
            freq.put(key, count - 1);
            Node prevNode = currNode.prev;
            if (prevNode == head || prevNode.keys.size() > 0) {
                addNodeAfter(new Node(), prevNode);
                prevNode = prevNode.next;
            }
            moveKey(key, currNode, prevNode);
        }
    }
    
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void addNodeAfter(Node newNode, Node prevNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeKeyFromNode(String key, Node node) {
        node.keys.remove(key);
        keyNodeMapping.remove(key);
        if (node.keys.isEmpty()) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void moveKey(String key, Node fromNode, Node toNode) {
        removeKeyFromNode(key, fromNode);
        toNode.keys.add(key);
        keyNodeMapping.put(key, toNode);
    }

    private class Node {
        Set<String> keys;
        Node prev;
        Node next;

        Node() {
            this.keys = new HashSet<>();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */