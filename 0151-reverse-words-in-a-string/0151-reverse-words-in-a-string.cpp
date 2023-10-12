class Solution {
public:
    string reverseWords(string s) {
        int len = s.size();

        vector<string> tokens;
        string temp = "";
        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                if (temp != "") {
                    tokens.push_back(temp);
                    temp = ""; 
                }
            } else {
                temp = temp + s[i];
            }
        }
        if (temp != "") {
            tokens.push_back(temp);
        }

        
        string res = "";
        for (int i = tokens.size() - 1; i >= 0; i--) {
            res.append(tokens[i]);

            if (i != 0) {
                res.append(" ");
            } 
        }

        return res;
    }
};