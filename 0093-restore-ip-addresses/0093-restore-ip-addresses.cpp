class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        solve(0, 0, s, "", res);

        return res;
    }

private:
    void solve(int idx, int dots, string str, string curr, vector<string> &res) {
        if (dots == 3 ) {       
            string lastPart = str.substr(idx);
            curr = curr + lastPart;
            if (isValidIP(curr)) {
                res.push_back(curr);
            }

            return;
        }

        if (idx >= str.size()) {
            return;
        }

        string temp = "";
        for (int i = idx; i < idx + 3 && i < str.size(); i++) {
            temp = temp + str[i];
            if (isValidPart(temp)) {
                solve(i + 1, dots + 1, str, curr + temp + '.', res);
            }
        }
    }

    bool isValidIP(string ip) {
        vector<string> parts = split(ip, '.');

        // check if there are 4 parts or not
        if (parts.size() != 4) {
            return false;
        } else {
            for (int i = 0; i < parts.size(); i++) {
                string part = parts[i];
                
                // check whether each part is valid or not
                if (!isValidPart(part)) {
                    return false;
                }
            }
        }

        // return true when both of the above conditions are false
        return true;
    }

    bool isValidPart(string part) {
        // if part contains leading 0's return false
        if (part.size() > 1  && part[0] == '0') {
            return false;
        }

        if (part.size() > 3) {
            return false;
        }

        // if part is less than 0 or greater than 255 return false
        cout << part << endl;
        int partVal = stoi(part);
        if (partVal < 0 || 255 < partVal) {
            return false;
        }

        // return true if both of the above are false
        return true;
    }

    vector<string> split(const string &s, char delimiter) {
        vector<std::string> tokens;
        istringstream stream(s);
        string token;

        while (getline(stream, token, delimiter)) {
            tokens.push_back(token);
        }

        return tokens;
    }
};
