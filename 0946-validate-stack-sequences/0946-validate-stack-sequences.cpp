class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        int len1 = pushed.size();
        int len2 = popped.size();
        stack<int> st;
        int j = 0;
        for (int i = 0; i < len1; i++) {
            st.push(pushed[i]);

            while (st.size() > 0 && j < len2 && popped[j] == st.top()) {
                st.pop();
                j++;
            }
        }

        if (st.size() > 0 || j != len2) {
            return false;
        }

        return true; 
    }
};