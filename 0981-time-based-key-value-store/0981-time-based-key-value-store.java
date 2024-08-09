class TimeMap {

    HashMap<String, TreeMap<Integer, String>> kvStore;
    public TimeMap() {
        kvStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> values = kvStore.getOrDefault(key, new TreeMap<>());
        values.put(timestamp, value);
        kvStore.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        // System.out.println(kvStore);
        TreeMap<Integer, String> values = kvStore.get(key);
        if (values == null) {
            return "";
        }
        
        Integer floorKey = values.floorKey(timestamp);
        if (floorKey == null) {
            return "";
        }
        return values.get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */