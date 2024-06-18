class Solution {
public:
    int maxProfitAssignment(vector<int> &difficulty, vector<int> &profit, vector<int> &worker) {
        int n = difficulty.size();
        vector<pair<int, int>> diffProfit;

        for (int i = 0; i < n; i++) {
            diffProfit.push_back({difficulty[i], profit[i]});
        }
        sort(diffProfit.begin(), diffProfit.end());

        int m = worker.size();
        sort(worker.begin(), worker.end());
        priority_queue<int> pq;
        int res = 0;
        for (int i = 0, j = 0; j < m; j++) {
            while (i < n && diffProfit[i].first <= worker[j]) {
                pq.push(diffProfit[i].second);
                i++;
            }

            if (pq.size() > 0) {
                res += pq.top();    
            }
        }

        return res;
    }
};