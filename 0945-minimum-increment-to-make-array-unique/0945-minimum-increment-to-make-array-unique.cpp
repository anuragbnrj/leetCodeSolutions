using ll = long long;

class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        int n = nums.size();

        unordered_set<int> isUsed;
        sort(nums.begin(), nums.end());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            int beg = num;
            int end = INT_MAX;

            while (beg < end) {
                int mid = beg + ((end - beg) >> 1);

                if (isUsed.find(mid) != isUsed.end()) beg = mid + 1;
                else end = mid; 
            }

            isUsed.insert(beg);
            ans += beg - num;
        }

        
        return ans;
    }
};