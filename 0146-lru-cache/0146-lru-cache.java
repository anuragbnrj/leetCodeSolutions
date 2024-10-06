class LRUCache {
    private static int max_capacity;
    Map<Integer, Integer> kvStore;

    public LRUCache(int capacity) {
        max_capacity = capacity;
        this.kvStore = new LinkedHashMap<>(capacity, 1.0F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > max_capacity;
            }
        };    
    }
    
    public int get(int key) {
        if (!kvStore.containsKey(key)) {
            return -1;
        }

        return kvStore.get(key);
    }
    
    public void put(int key, int value) {
        kvStore.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */