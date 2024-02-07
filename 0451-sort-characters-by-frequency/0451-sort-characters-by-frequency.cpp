class Solution {
public:
    string frequencySort(string s) {
        int len = s.size();

        unordered_map<char, int> freq;
        for (char ch : s) {
            freq[ch]++;
        }

        vector<pair<int, char>> temp;
        for (auto el : freq) {
            temp.push_back({el.second, el.first});
        }
        
        sort(temp.begin(), temp.end());
        reverse(temp.begin(), temp.end());
        string res = "";
        for (int i = 0; i < (int)temp.size(); i++) {
            int freq = temp[i].first;
            char ch = temp[i].second;
            for (int j = 0; j < freq; j++) {
                res += ch;
            }
        }

        return res;
    }
};