class SnapshotArray {
    Map<Integer, TreeMap<Integer, Integer>> timeValMap;
    int len;
    int currTime;

    public SnapshotArray(int length) {
        timeValMap = new HashMap<>();
        len = length;
        currTime = -1;
        for (int i = 0; i < len; i++) {
            TreeMap<Integer, Integer> temp = new TreeMap<>();
            temp.put(currTime, 0);
            timeValMap.put(i, temp);
        }
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> temp = timeValMap.get(index);

        temp.put(currTime, val);
    }
    
    public int snap() {
        currTime += 1;
        return currTime;
    }
    
    public int get(int index, int snap_id) {
        // System.out.println(timeValMap.toString());
        TreeMap<Integer, Integer> temp = timeValMap.get(index);

        int key = temp.lowerKey(snap_id);
        return temp.get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */