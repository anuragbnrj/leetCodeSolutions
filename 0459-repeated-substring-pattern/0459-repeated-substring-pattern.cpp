class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int len = s.size();
        vector<int> kmp = getKMPArray(s);

        int last = kmp[len];

        if (len % (len - last) == 0) {
            return true;
        } 

        return false;
    }

private:
    vector<int> getKMPArray(string s) {
        int len = s.size();

        vector<int> kmp(len + 1);
        kmp[0] = -1;

        int i = 0, j = -1;
        while (i < len) {
            while (j != -1 && s[i] != s[j]) {
                j = kmp[j];
            }
            j++;
            i++;
            kmp[i] = j;
        }

        return kmp;
    }
};