class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        int len = nums.size();
        vector<int> count(201, 0);
        int mx = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            count[nums[i]] += 1;
            mx = max(mx, count[nums[i]]);
        }

        int temp = len;
        vector<vector<int>> res(mx);
        int row = 0;
        while (temp > 0) {
            for (int i = 0; i <= 200; i++) {
                if (count[i] > 0) {
                    count[i] = count[i] - 1;
                    res[row].push_back(i);
                    temp = temp - 1;
                }
            }
            row++;
        }


        return res;
    }
};