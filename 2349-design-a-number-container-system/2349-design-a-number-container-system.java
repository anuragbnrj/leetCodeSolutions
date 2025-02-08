class NumberContainers {

    Map<Integer, Integer> indexContent;
    Map<Integer, TreeSet<Integer>> locations;

    public NumberContainers() {
        indexContent = new HashMap<>();
        locations = new HashMap<>();    
    }
    
    public void change(int index, int number) {
        if (indexContent.containsKey(index)) {
            int prevVal = indexContent.get(index);
            locations.get(prevVal).remove(index);

            if (locations.get(prevVal).size() == 0) {
                locations.remove(prevVal);
            }
        }

        indexContent.put(index, number);
        TreeSet<Integer> currLocations = locations.getOrDefault(number, new TreeSet<>());
        currLocations.add(index);
        locations.put(number, currLocations);
    }
    
    public int find(int number) {
        if (locations.containsKey(number)) {
            return locations.get(number).first();
        }

        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */