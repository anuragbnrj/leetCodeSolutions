class Solution {
public:
    bool checkValidString(string s) {
        int n = s.size();

        stack<int> st;
        vector<bool> isBalanced(n, false);
        for (int i = 0; i < n; i++) {
            char ch = s[i];
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (!st.empty()) {
                    int idx = st.top();
                    st.pop();
                    isBalanced[idx] = true;
                    isBalanced[i] = true;
                }
            }
        }

        string temp = "";
        for (int i = 0; i < n; i++) {
            if (!isBalanced[i]) {
                temp += s[i];
            }
        }
        cout << "Temp: " << temp << endl;

        stack<char> tempst;
        for (int i = 0; i < temp.size(); i++) {
            char ch = temp[i];
            if (ch == '(') {
                tempst.push(ch);
            } else if (ch == '*') {
                if (!tempst.empty() && tempst.top() == '(') {
                    tempst.pop();
                } else {
                    tempst.push(ch);
                }
            } else {
                if (tempst.empty()) {
                    return false;
                } else {
                    tempst.pop();
                }
            }
        }
        
        while (!tempst.empty()) {
            char ch = tempst.top();
            tempst.pop();

            if (ch != '*') {
                return false;
            }
        }


        return true;
    }
};