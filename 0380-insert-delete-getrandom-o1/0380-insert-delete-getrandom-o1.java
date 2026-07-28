class RandomizedSet {
    private HashMap<Integer, Integer> idxMap;
    private ArrayList<Integer> list;

    public RandomizedSet() {
        idxMap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }

        list.add(val);
        idxMap.put(val, list.size() - 1);

        return true;
    }
    
    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }

        int removalIdx = idxMap.get(val);
        int lastEl = list.get(list.size() - 1);

        list.set(removalIdx, lastEl);
        list.remove(list.size() - 1);

        idxMap.put(lastEl, removalIdx);

        idxMap.remove(val);

        return true;
    }
    
    public int getRandom() {
        int randomIdx = (int) (Math.random() * list.size());

        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */