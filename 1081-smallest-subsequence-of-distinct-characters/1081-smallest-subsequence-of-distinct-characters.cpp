class Solution {
public:
    string smallestSubsequence(string s) {
        int len = s.size();
        vector<bool> present(26, false);
        vector<int> lastOccurrence(26, 0);
        for (int i = 0; i < len; i++) {
            char ch = s[i];
            lastOccurrence[ch - 'a'] = i;
        }

        stack<char> st;
        for (int i = 0; i < len; i++) {
            char ch = s[i];

            if (st.empty()) {
                st.push(ch);
                present[ch - 'a'] = true;
            } else {
                while (!st.empty() && ch < st.top() && lastOccurrence[st.top() - 'a'] > i && !present[ch - 'a']) {
                    char top = st.top();
                    st.pop();
                    present[top - 'a'] = false;
                }

                if (!present[ch - 'a']) {
                    st.push(ch);
                    present[ch - 'a'] = true;
                }
            }

        }

        string res = "";
        while (!st.empty()) {
            res.push_back(st.top());
            st.pop();
        }

        reverse(res.begin(), res.end());
        return res;
        
    }
};