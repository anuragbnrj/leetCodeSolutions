class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        set<string> dict(wordDict.begin(), wordDict.end());
        vector<string> res;
        
        string word = "";
        string sentence = "";
        solve(0, s, dict, word, sentence, res);

        return res;
    }

private:
    void solve(int idx, string s, set<string> &dict, string word, string sentence, vector<string> &res) {
        word += s[idx];

        int n = s.size();
        if (idx == (n - 1)) {
            // cout << sentence << ": " << word << endl;
            if ((dict.find(word) != dict.end())) {
                sentence += word;
                res.push_back(sentence);
            }
            
            return;
        }

        
        if (dict.find(word) != dict.end()) {
            solve(idx + 1, s, dict, "", sentence + word + ' ', res);
        }
        solve(idx + 1, s, dict, word, sentence, res);
    }
};