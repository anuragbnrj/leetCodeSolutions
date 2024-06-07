class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        int  n = sentence.size();

        set<string> dict(dictionary.begin(), dictionary.end());
        string currWord = "";
        vector<string> words;
        bool stop = false;
        for (char ch : sentence) {
            if (ch == ' ') {
                if (stop == false) words.push_back(currWord);
                currWord = "";
                stop = false;
            } else {
                if (stop == false) {
                    currWord += ch;
                    if (dict.find(currWord) != dict.end()) {
                        words.push_back(currWord);
                        stop = true;
                    }
                }  
            }
        }

        if (stop == false && currWord.size() > 0) {
            words.push_back(currWord);
        }

        string res = "";
        for (int i = 0; i < words.size(); i++) {
            if (i != 0) res += ' ';
            res += words[i];
        }
        
        return res;
    }
};