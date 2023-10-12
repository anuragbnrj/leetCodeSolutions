class Solution {
public:
    string reverseWords(string s) {
        int len = s.size();
        int beg = 0;
        int end = len - 1;

        vector<string> tokens;
        string temp = "";
        for (int i = beg; i <= end; i++) {
            if (s[i] == ' ') {
                if (temp != "") {
                    cout << "i: " << i << "\t temp: " << temp << endl;
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
        // cout << "size: " << tokens.size() << endl; 

        reverse(tokens.begin(), tokens.end());
        string res = "";
        for (int i = 0; i < tokens.size(); i++) {
            res = res + tokens[i];

            if (i != tokens.size() - 1) {
                res += ' ';
            } 
        }

        return res;
    }
};