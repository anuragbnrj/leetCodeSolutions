class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        int n = arr.size();
        priority_queue<pair<double, pair<int, int>>> pq;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double frac = (1.0 * arr[i]) / arr[j];

                pq.push({frac, {arr[i], arr[j]}});

                if (pq.size() > k) {
                    pq.pop();
                }
            }
        }

        auto top = pq.top();
        return {top.second.first, top.second.second};
    }
};