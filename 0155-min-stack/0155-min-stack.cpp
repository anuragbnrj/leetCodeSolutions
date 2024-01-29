class MinStack {
public:
    vector<int> arr;
    stack<int> minIdx;

    MinStack() {
        
    }
    
    void push(int val) {
        arr.push_back(val);
        int idx = arr.size() - 1;

        if (minIdx.size() == 0) {
            minIdx.push(idx);
        } else {
            if (val < arr[minIdx.top()]) {
                minIdx.push(idx);
            }
        }   
    }
    
    void pop() {
        int idx = arr.size() - 1;
        arr.pop_back();

        if (minIdx.top() == idx) {
            minIdx.pop();
        }
    }
    
    int top() {
        return arr[(int)arr.size() - 1];
    }
    
    int getMin() {
        return arr[minIdx.top()];
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */