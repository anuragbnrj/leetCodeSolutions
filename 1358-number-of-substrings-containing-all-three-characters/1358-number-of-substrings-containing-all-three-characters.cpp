class Solution {
public:
    int numberOfSubstrings(string s) {
        return solve(s, 3);
    }

private:
    int solve(string s, int k) {
        int n = s.size();

        int res = 0;
        unordered_map<char, int> freq;
        for (int beg = 0, end = 0; end < n; end++) {
            char ch = s[end];
            freq[ch]++;

            while (freq.size() == k) {
                res += n - end;

                char del = s[beg];
                freq[del]--;

                if (freq[del] == 0) {
                    freq.erase(del);
                }

                beg++;
            }

        }

        return res;
    }
};