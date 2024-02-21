class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        long long ans = 0;
        for (int bit = 0; bit < 31; bit++) {
            if (((left >> bit) & 1) == 1 && ((right >> bit) & 1) == 1) {
                if ((right - left) > pow(2, bit)) {
                    
                } else {
                    ans += (1 << bit);
                }
            } else {
                
            }
        }

        return ans;
    }
};