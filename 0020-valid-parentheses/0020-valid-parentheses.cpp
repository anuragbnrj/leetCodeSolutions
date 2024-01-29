class Solution {
public:
    bool isValid(string s) {
        unordered_map<char, char> comp;
        comp[')'] = '(';
        comp[']'] = '[';
        comp['}'] = '{';
        stack<char> st;

        for (char ch : s) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.size() == 0 || st.top() != comp[ch]) {
                    return false;
                }
                st.pop();
            }
        }

        if (st.size() > 0) {
            return false;
        }
        
        return true;
    }
};