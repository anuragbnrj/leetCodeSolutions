class Solution {
public:
    int tribonacci(int n) {
        vector<int> t = {0, 1, 1};

        if (n <= 2) {
            return t[n];
        }

        for (int i = 3; i <= n; i++) {
            int sum = t[0] + t[1] + t[2];
            t[0] = t[1];
            t[1] = t[2];
            t[2] = sum;
        }

        return t[2];
        
    }
};