class Solution {
public:
    int minInsertions(string s) {
        int len = s.size();
        int res = 0;
        stack<char> st;
        string curr = "";
        for (int i = 0; i < len; ) {
            char ch = s[i];

            if (ch == '(') {
                st.push(ch);
                i++;
            } else if (ch == ')') {
                if (i < len - 1 ) {
                    if (s[i + 1] == ')') {
                        if (st.size() > 0) {
                            st.pop();
                            
                        } else {
                            res += 1;
                        }

                        i += 2;
                    } else if (s[i + 1] == '(') {
                        if (st.size() > 0) {
                            st.pop();
                            res += 1;
                        } else {
                            res += 2;
                        }
                        
                        i += 1;
                    }
                } else {
                    if (st.size() > 0) {
                        st.pop();
                        res += 1;
                    } else {
                        res += 2;
                    }
                
                    i++;
                }
            }   
        }

        res += (st.size() * 2);

        return res;
    }
};