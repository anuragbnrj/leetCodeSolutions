class Solution {
public:
    string removeKdigits(string num, int k) {
        int n = num.size();

        vector<int> a(n, 0);
        for (int i = 0; i < n; i++) {
            a[i] = num[i] - '0';
        }

        stack<int> st;
        vector<int> nseIdx(n, n);
        for (int i = 0; i < n; i++) {
            while (!st.empty() && a[st.top()] > a[i]) {
                int top = st.top();
                st.pop();
                nseIdx[top] = i;
            }

            st.push(i);
        }

        int ctr = 0;
        vector<int> temp(n, -1);
        for (int i = 0; i < n && ctr < k; i++) {
            if (nseIdx[i] != n) {
                a[i] = -1;
                ctr++;
            }
        }
        for (int i = n - 1; i >= 0 && ctr < k; i--) {
            a[i] = -1;
            ctr++;
        }

        for (int i = 0; i < n; i++) {
            cout << a[i] << " ";
        }
        cout << endl;

        string res = "";
        int idx = 0; 
        for (idx = 0; idx < n && a[idx] <= 0; idx++) {

        }
        // cout << idx << endl;
        for (; idx < n; idx++) {
            if (a[idx] != -1) {
                res += (a[idx] + '0');
            }
        }

        if (res == "") {
            res = "0";
        }
        return res;
    }
};