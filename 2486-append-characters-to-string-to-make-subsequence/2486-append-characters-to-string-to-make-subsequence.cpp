class Solution {
public:
    int appendCharacters(string s, string t) {
        int i, j;

        for (i = 0, j = 0; i < s.size() && j < t.size(); ) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return (int(t.size()) - j);
    }
};