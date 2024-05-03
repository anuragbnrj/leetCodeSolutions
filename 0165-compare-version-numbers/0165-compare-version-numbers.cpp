class Solution {
public:
    int compareVersion(string version1, string version2) {
        vector<int> v1;
        string temp = "";
        for (auto ch : version1) {
            if (ch == '.') {
                v1.push_back(stoi(temp));
                temp = "";
            } else {
                temp += ch;
            }
        }
        v1.push_back(stoi(temp));
        temp = "";

        vector<int> v2;
        for (auto ch : version2) {
            if (ch == '.') {
                v2.push_back(stoi(temp));
                temp = "";
            } else {
                temp += ch;
            }
        }
        v2.push_back(stoi(temp));
        temp = "";

        // for (int i = 0; i < v1.size(); i++) {
        //     cout << v1[i] << "\t";
        // }
        // cout << endl;
        // for (int i = 0; i < v2.size(); i++) {
        //     cout << v2[i] << "\t";
        // }
        // cout << endl;


        int i = 0;
        for ( ; i < v1.size() && i < v2.size(); i++) {
            if (v1[i] < v2[i]) {
                return -1;
            } else if (v1[i] > v2[i]) {
                return 1;
            }
        }

        for ( ; i < v1.size(); i++) {
            if (v1[i] != 0) {
                return 1;
            }
        }

        for ( ; i < v2.size(); i++) {
            if (v2[i] != 0) {
                return -1;
            }
        }

        return 0;
    }
};