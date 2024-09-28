class MyCircularDeque {
    int maxSize;
    int currSize;
    Node head, tail;

    public MyCircularDeque(int k) {
        maxSize = k;
        currSize = 0;

        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if (currSize >= maxSize) {
            return false;
        }

        Node newNode = new Node(value);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode; 
        currSize += 1;

        return true;
    }
    
    public boolean insertLast(int value) {
        if (currSize >= maxSize) {
            return false;
        }

        Node newNode = new Node(value);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        currSize += 1;

        return true;
    }
    
    public boolean deleteFront() {
        if (currSize == 0) {
            return false;
        }

        Node toBeDeleted = head.next;
        toBeDeleted.next.prev = toBeDeleted.prev;
        toBeDeleted.prev.next = toBeDeleted.next;
        toBeDeleted.prev = null;
        toBeDeleted.next = null;
        currSize -= 1;

        return true;
    }
    
    public boolean deleteLast() {
        if (currSize == 0) {
            return false;
        }

        Node toBeDeleted = tail.prev;
        toBeDeleted.next.prev = toBeDeleted.prev;
        toBeDeleted.prev.next = toBeDeleted.next;
        toBeDeleted.prev = null;
        toBeDeleted.next = null;
        currSize -= 1;

        return true;
    }
    
    public int getFront() {
        if (currSize == 0) {
            return -1;
        }

        return head.next.val;
    }
    
    public int getRear() {
        if (currSize == 0) {
            return -1;
        }

        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return currSize == 0 ? true : false;
    }
    
    public boolean isFull() {
        return currSize == maxSize ? true : false;
    }

    class Node {
        int val;
        Node prev;
        Node next;

        public Node() {
            val = 0;
            prev = null;
            next = null;
        }

        public Node(int v) {
            val = v;
            prev = null;
            next = null;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */