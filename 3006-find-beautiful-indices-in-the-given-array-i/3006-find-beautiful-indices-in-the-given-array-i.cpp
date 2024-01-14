class Solution {
public:
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        vector<int> occurA;
        vector<int> occurB;
        
        // int pos = s.find(a);
        // while (pos != std::string::npos) {
        //     occurA.push_back(pos);
        //     pos = s.find(a, pos + 1);
        // }
        
        // pos = s.find(b);
        // while (pos != std::string::npos) {
        //     occurB.push_back(pos);
        //     pos = s.find(b, pos + 1);
        // }
        
        int ptr = 0;
        int st = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != a[ptr]) {
                ptr = 0;
            } 
            
            if (s[i] == a[ptr]) {
                if (ptr == (a.size() - 1)) {
                    if (ptr == 0) {
                        st = i;
                    }
                    occurA.push_back(st);
                    ptr = 0;
                } else if (ptr == 0) {
                    st = i;
                    ptr++;
                } else {
                    ptr++;
                }
            }
        }
        
        ptr = 0;
        st = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != b[ptr]) {
                ptr = 0;
            } 
            
            if (s[i] == b[ptr]) {
                if (ptr == (b.size() - 1)) {
                    if (ptr == 0) {
                        st = i;
                    }
                    occurB.push_back(st);
                    ptr = 0;
                } else if (ptr == 0) {
                    st = i;
                    ptr++;
                } else {
                    ptr++;
                }
            }
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