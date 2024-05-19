class Solution {
public:
    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        int n = nums.size();

        priority_queue<pair<int, int>> pq;
        long long baseSum = 0;
        for (int i = 0; i < n; i++) {
            baseSum += nums[i];
            int nval = nums[i] ^ k;

            int delta = nval - nums[i];
            pq.push_back({delta, i});
        }

        while (pq.size() >= 2) {
            auto a = pq.top(); 
            pq.pop();
            auto b = pq.top(); pq.pop()
        }
    }
};