class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        int len = tokens.size();
        stack<string> st;

        for (int i = 0; i < len; i++) {
            string str = tokens[i];
            if (str == "+" || str == "-" || str == "*" || str == "/") {
                int b = stoi(st.top()); st.pop();
                int a = stoi(st.top()); st.pop();


                if (str == "+") {
                    int c = a + b;
                    st.push(to_string(c));
                } else if (str == "-") {
                    int c = a - b;
                    st.push(to_string(c));
                } else if (str == "*") {
                    int c = a * b;
                    st.push(to_string(c));
                } else {
                    int c = a / b;
                    st.push(to_string(c));
                }

            } else {
                st.push(str);
            }
        }
        
        return stoi(st.top());
    }
};