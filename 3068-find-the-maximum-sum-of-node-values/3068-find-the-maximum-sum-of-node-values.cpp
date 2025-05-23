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
            pq.push({delta, i});
        }

        long long res = baseSum;
        while (pq.size() >= 2) {
            auto a = pq.top(); 
            pq.pop();
            long long deltaA = a.first;

            auto b = pq.top(); 
            pq.pop();
            long long deltaB = b.first;

            long long deltaNet = deltaA + deltaB;

            if (deltaNet <= 0) {
                break;
            } else {
                res += deltaNet;
                pq.push({-deltaA, a.second});
                pq.push({-deltaB, b.second});
            }

        }

        return res;
    }
};