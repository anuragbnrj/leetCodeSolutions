class Solution {
public:
    bool halvesAreAlike(string s) {
        int len = s.size();
        int count = 0;

        for (int i = 0; i < len / 2; i++) {
            char ch = tolower(s[i]);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count += 1;
            }
        }

        for (int i = len / 2; i < len; i++) {
            char ch = tolower(s[i]);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (count <= 0) {
                    return false;
                }

                count -= 1;
            }
        }

        if (count > 0) {
            return false;
        }

        return true;
    }
};