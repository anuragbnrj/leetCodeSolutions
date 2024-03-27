class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        int len = s.size();

        map<string, int> freq;
        for (int i = 0; i + 9 < len; i++) {
            string substr = "";

            for (int j = 0; j < 10; j++) {
                substr += s[i + j];
            }

            freq[substr]++;
        }
        
        vector<string> res;
        for (auto el : freq) {
            string str = el.first;
            int count = el.second;

            // cout << str << ": " << count << endl;

            if (count > 1) {
                res.push_back(str);
            }
        }

        return res;
    }
};