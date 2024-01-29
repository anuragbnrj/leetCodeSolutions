class MyQueue {
public:
    stack<int> s;
    stack<int> temp;    
    MyQueue() {
        
    }
    
    void push(int x) {
        s.push(x);
    }
    
    int pop() {
        while(s.size() > 1) {
            int top = s.top();
            s.pop();
            temp.push(top);
        }

        int res = s.top();
        s.pop();

        while (temp.size()) {
            int top = temp.top();
            temp.pop();
            s.push(top);
        }

        return res;
    }
    
    int peek() {
        while(s.size() > 1) {
            int top = s.top();
            s.pop();
            temp.push(top);
        }

        int res = s.top();

        while (temp.size()) {
            int top = temp.top();
            temp.pop();
            s.push(top);
        }

        return res; 
    }
    
    bool empty() {
        return s.size() == 0;
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */