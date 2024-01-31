class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int len = temperatures.size();
        stack<int> st;
        vector<int> ngeIndices(len, -1);
        for (int i = 0; i < len; i++) {
            while (st.size() > 0 && temperatures[st.top()] < temperatures[i]) {
                int idx = st.top();
                st.pop();
                ngeIndices[idx] = i;
            }

            st.push(i);
        }

        vector<int> res(len, 0);

        for (int i = 0; i < len; i++) {
            if (ngeIndices[i] != -1) {
                res[i] = (ngeIndices[i] - i);
            }
        }

        return res;
    }
};