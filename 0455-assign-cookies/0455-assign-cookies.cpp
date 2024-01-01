class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        reverse(g.begin(), g.end());
        sort(s.begin(), s.end());
        reverse(s.begin(), s.end());

        int res = 0;
        for(int i = 0, j = 0; j < s.size() && i < g.size();) {
            if (s[j] >= g[i]) {
                res++;
                j++;
                i++;
            } else {
                i++;
            }
        }
        
        return res;
    }
};