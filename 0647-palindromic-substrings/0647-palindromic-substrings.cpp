class Solution {
public:
    int countSubstrings(string s) {
        int len = s.size();
        
        int res = 0;
        int left, right;
        // Even length palindromes:
        for (int i = 0; i < len - 1; i++) {
            left = i;
            right = i + 1;

            while (left >=0 && right < len && s[left] == s[right]) {
                res++;
                left -= 1;
                right += 1;
            }
        }

        // Odd length palindromes:
        for (int i = 0; i < len; i++) {
            left = i;
            right = i;

            while (left >=0 && right < len && s[left] == s[right]) {
                res++;
                left -= 1;
                right += 1;
            }
        }
        
        return res;
    }
};