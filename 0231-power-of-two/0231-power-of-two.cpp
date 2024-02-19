class Solution {
public:
    bool isPowerOfTwo(int n) {
        long long temp = n;
        if (temp == 0) {
            return false;
        }
        if ((temp & temp - 1) == 0) {
            return true;
        }

        return false;
    }
};