class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int len = arr.size();
        priority_queue<pair<int, int>> pq;

        for (int i = 0; i < len; i++) {
            int dist = abs(arr[i] - x);

            pq.push({dist, arr[i]});

            if (pq.size() > k) {
                pq.pop();
            }
        }
        
        vector<int> res;
        while (pq.size() > 0) {
            int top = pq.top().second;
            pq.pop();
            res.push_back(top);
        }

        sort(res.begin(), res.end());
        return res;
    }
};