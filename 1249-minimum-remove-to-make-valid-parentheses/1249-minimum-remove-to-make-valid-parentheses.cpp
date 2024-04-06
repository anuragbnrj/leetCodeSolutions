class Solution {
public:
    string minRemoveToMakeValid(string s) {
        int n = s.size();

        stack<char> st;
        string res = "", curr = "";
        for (char ch : s) {
            if (ch == '(') {
                curr += ch;
                st.push(ch);
            } else if (ch == ')') {
                if (!st.empty()) {
                    st.pop();
                    curr += ch;
                    if (st.empty()) {
                        res += curr;
                        curr = "";
                    } else {

                    }
                } else {

                }
            } else {
                if (st.empty()) {
                    res += ch;
                } else {
                    curr += ch;
                }

            }
        }

        for (char ch : curr) {
            if (ch == '(') {

            } else {
                res += ch;
            }
        }

        return res;
    }
};