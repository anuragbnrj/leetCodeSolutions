class MinStack {

    Stack<Pair> st;
    public MinStack() {
        st = new Stack();
    }
    
    public void push(int val) {
        if (st.size() == 0) {
            Pair p = new Pair(val, val);
            st.push(p);
        } else {
            Pair top = st.peek();
            int mn = Math.min(top.minTillNow, val);
            Pair p = new Pair(val, mn);
            st.push(p);
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        Pair top = st.peek();
        return top.val;
    }
    
    public int getMin() {
        Pair top = st.peek();
        return top.minTillNow;
    }

    class Pair {
        int val;
        int minTillNow;

        public Pair(int v, int m) {
            this.val = val;
            this.minTillNow = m;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */