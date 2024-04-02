class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }

        map<char, char> mapping;
        map<char, set<int>> indegree;
        string temp = "";

        for (int i = 0; i < s.size(); i++) {
            char ch1 = s[i];
            char ch2 = t[i];

            if (mapping.find(ch1) != mapping.end()) {
                temp += mapping[ch1];
            } else {
                temp += ch2;
                mapping[ch1] = ch2;
                indegree[ch2].insert(ch1);

                if (indegree[ch2].size() > 1) {
                    return false;
                }
            }
        }

        return t == temp;
    }

};