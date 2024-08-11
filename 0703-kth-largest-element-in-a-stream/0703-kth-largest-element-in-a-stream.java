class KthLargest {

    PriorityQueue<Integer> pq;
    int allowedSize;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        allowedSize = k;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);

            if (pq.size() > allowedSize) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if (pq.size() > allowedSize) {
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */