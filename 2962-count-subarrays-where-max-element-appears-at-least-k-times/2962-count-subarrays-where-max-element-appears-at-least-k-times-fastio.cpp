auto init = []()
{
    ios::sync_with_stdio(false);  
    cin.tie(nullptr);            
    cout.tie(nullptr);           
    return 'c';                  
}();
class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        int len = nums.size();
        int maxEl = *max_element(nums.begin(), nums.end());

        int count = 0;
        long long res = 0;
        for (int beg = 0, end = 0; end < len; end++) {
            if (nums[end] == maxEl) {
                count++;
            }

            while (beg <= end && count >= k) {
                res += (len - 1 - end + 1);

                if (nums[beg] == maxEl) {
                    count--;
                }
                beg++;
            }
        }

        return res;
    }
};