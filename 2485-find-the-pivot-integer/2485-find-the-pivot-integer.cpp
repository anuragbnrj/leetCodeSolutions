class Solution {
public:
    int pivotInteger(int n) {
        int totSum = (n * (n + 1)) / 2;

        int currSum = 0;
        for (int i = 1; i <= n; i++) {
            currSum += i;

            int remaining = totSum - currSum + i;

            if (currSum == remaining) {
                return i;
            }
        }

        return -1;
        
    }
};