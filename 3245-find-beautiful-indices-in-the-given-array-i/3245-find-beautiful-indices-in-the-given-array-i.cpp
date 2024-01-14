class Solution {
public:
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        vector<int> occurA;
        vector<int> occurB;
        
        int pos = s.find(a);
        while (pos != std::string::npos) {
            occurA.push_back(pos);
            pos = s.find(a, pos + 1);
        }
        
        pos = s.find(b);
        while (pos != std::string::npos) {
            occurB.push_back(pos);
            pos = s.find(b, pos + 1);
        }
        
        vector<int> res;
        for (int elA : occurA) {
            for (int elB : occurB) {
                if (abs(elB - elA) <= k) {
                    res.push_back(elA);
                    break;
                }
            }
        }
        
        return res;
    }
};