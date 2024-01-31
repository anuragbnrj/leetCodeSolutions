class KthLargest {
public:
    priority_queue<int, vector<int>, greater<int>> minHeap;
    int kGlobal;
    
    KthLargest(int k, vector<int>& nums) {
        kGlobal = k;
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            minHeap.push(nums[i]);

            while (minHeap.size() > k) {
                minHeap.pop();
            }
        }    
    }
    
    int add(int val) {
        minHeap.push(val);
        while (minHeap.size() > kGlobal) {
            minHeap.pop();
        }

        return minHeap.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */