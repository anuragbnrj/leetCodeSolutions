class Solution {
public:
    int maxDepth(string s) {
        int currDepth = 0;
        int res = 0;

        for (char ch : s) {
            if (ch == '(') {
                currDepth++;
            }

            if (ch == ')') {
                currDepth--;
            }

            res = max(res, currDepth);
        }
        
        return res;
    }
};