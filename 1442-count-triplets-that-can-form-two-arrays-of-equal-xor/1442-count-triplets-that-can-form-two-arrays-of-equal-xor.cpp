class Solution {
public:
    int countTriplets(vector<int>& arr) {
        int n = arr.size();

        vector<int> temp(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            temp[i] = arr[i - 1] ^ temp[i - 1];
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    int xr1 = temp[j - 1] ^ temp[i - 1];

                    int xr2 = temp[k] ^ temp[j - 1];

                    if (xr1 == xr2) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
};