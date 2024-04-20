typedef long long ll;

class Solution {
public:
    int sumOfPower(vector<int>& nums) {
        int mod = 1e9 + 7;
        int n = nums.size();
        sort(nums.begin(), nums.end());

        ll res = (((1LL * nums[0] * nums[0]) % mod) * nums[0]) % mod;
        ll prev = nums[0];
        for (int i = 1; i < n; i++) {
            ll curr = nums[i];
            ll t1 = (curr * curr) % mod;

            ll t2 = (prev - nums[i - 1]) % mod;
            t2 = (t2 * 2) % mod;
            t2 = (((t2 + nums[i - 1]) % mod) + curr) % mod;

            ll t3 = (t1 * t2) % mod;

            res = (res + t3) % mod;
            prev = t2; 
        }

        res = (res + mod) % mod;

        return res;
    }
};