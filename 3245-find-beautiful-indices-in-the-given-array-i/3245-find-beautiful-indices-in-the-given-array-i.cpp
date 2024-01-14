class Solution {
public:
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        int len = s.size();
        int lenA = a.size();
        int lenB = b.size();

        vector<int> occurA, occurB;

        for (int i = 0; i < len; i++) {
            if (s.substr(i, lenA) == a) {
                occurA.push_back(i);
            }

            if (s.substr(i, lenB) == b) {
                occurB.push_back(i);
            }
        }

        vector<int> res;
        for (int i = 0; i < occurA.size(); i++) {
            for (int j = 0; j < occurB.size(); j++) {
                if (abs(occurA[i] - occurB[j]) <= k) {
                    res.push_back(occurA[i]);
                    break;
                }
            }
        }

        return res;
    }
};