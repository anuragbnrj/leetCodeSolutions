class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        int len = tokens.size();
        stack<int> st;

        for (int i = 0; i < len; i++) {
            string str = tokens[i];
            if (str == "+" || str == "-" || str == "*" || str == "/") {
                int b = (st.top()); st.pop();
                int a = (st.top()); st.pop();

                if (str == "+") {
                    int c = a + b;
                    st.push(c);
                } else if (str == "-") {
                    int c = a - b;
                    st.push(c);
                } else if (str == "*") {
                    int c = a * b;
                    st.push(c);
                } else {
                    int c = a / b;
                    st.push(c);
                }

            } else {
                st.push(stoi(str));
            }
        }
        
        return st.top();
    }
};