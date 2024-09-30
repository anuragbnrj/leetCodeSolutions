class CustomStack {
    ArrayList<Integer> arr;
    int currSize;
    int maxSize;

    public CustomStack(int size) {
        arr = new ArrayList<>();
        currSize = 0;
        maxSize = size; 
    }
    
    public void push(int x) {
        if (currSize < maxSize) {
            arr.add(x);
            currSize += 1;
        }
    }
    
    public int pop() {
        int popped = -1;
        if (currSize > 0) {
            popped = arr.remove(currSize - 1);
            currSize -= 1;
        }

        return popped;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < k && i < currSize; i++) {
            int currPlusVal = arr.get(i) + val;
            arr.set(i, currPlusVal);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */