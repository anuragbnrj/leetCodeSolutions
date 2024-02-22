class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        int len = trust.size();

        vector<int> freq(n + 1, 0);
        vector<bool> hasTrust(n + 1, false);
        for (int i = 0; i < len; i++) {
            // int t1 = trust[i - 1][1];
            hasTrust[trust[i][0]] = true;
            int t = trust[i][1];

            freq[t]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (freq[i] == (n - 1) && hasTrust[i] == false) {
                return i;
            }
        } 

        return -1;  
    }
};