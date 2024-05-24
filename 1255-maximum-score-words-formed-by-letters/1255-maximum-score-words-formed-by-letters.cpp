class Solution {
public:
    int res = 0;
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        vector<int> available(26, 0);
        for (int i = 0; i < letters.size(); i++) {
            available[letters[i] - 'a']++;
        }

        vector<int> reqd(26, 0);
        solve(0, words, score, available, reqd);

        return res;
    }

private:
    void solve(int idx, vector<string> &words, vector<int> &score, vector<int> &available, vector<int> &reqd) {
        if (idx == words.size()) {
            
            bool flag = true;
            int total = 0;
            for (int i = 0; i < 26; i++) {
                if (reqd[i] > available[i]) {
                    flag = false;
                    break;
                } else {
                    total += reqd[i] * score[i];
                }
                
            }

            if (flag == true) {
                res = max(res, total);
            }
            return;
        }


        int flag = true;
        string str = words[idx];
        for (int i = 0; i < str.size(); i++) {
            char ch = str[i];
            reqd[ch - 'a']++;

            if (reqd[ch - 'a'] > available[ch - 'a']) {
                flag = false;
            }
        }

        if (flag == true) {
            solve(idx + 1, words, score, available, reqd);
        }

        for (int i = 0; i < str.size(); i++) {
            char ch = str[i];
            reqd[ch - 'a']--;
        }

        solve(idx + 1, words, score, available, reqd);
    }
};