class Solution {
public:
    int longestAwesome(string s) {
        int n = s.size();

        map<int, int> prevLocation;
        prevLocation[0] = -1;

        int xr = 0;
        int res = 1;
        for (int i = 0; i < n; i++) {
            xr = xr ^ (1 << (s[i] - '0'));

            if (prevLocation.find(xr) != prevLocation.end()) {
                res = max(res, i - prevLocation[xr]);
            }

            for (int digit = 0; digit < 10; digit++) {
                int temp = xr ^ (1 << digit);
                if (prevLocation.find(temp) != prevLocation.end()) {
                    res = max(res, i - prevLocation[temp]);
                }
            }

            if (prevLocation.find(xr) == prevLocation.end()) {
                prevLocation[xr] = i;
            }
        }

        return res;
    }

};