class Solution {
public:
    int numberOfSubstrings(string s) {
        return solve(s, 3) - solve(s, 2);
    }

private:
    int solve(string s, int k) {
        int n = s.size();

        int res = 0;
        map<char, int> freq;
        for (int beg = 0, end = 0; end < n; end++) {
            char ch = s[end];
            freq[ch]++;

            while (freq.size() > k) {
                char del = s[beg];
                freq[del]--;

                if (freq[del] == 0) {
                    freq.erase(del);
                }

                beg++;
            }

            res += (end - beg + 1);
        }

        return res;
    }
};