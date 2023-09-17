class Solution {
public:
    
    int e8 = 1000000008;
    int maxNumberOfAlloys(int n, int k, int budget, vector<vector<int>>& composition, vector<int>& stock, vector<int>& cost) {
        
        int res = INT_MIN;
        for (int i = 0; i < k; i++) {
            int start = 0; int end = e8;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (isPossible(mid, i, n, budget, composition, stock, cost)) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            res = max(res, start - 1);
        }
        
        return max(res, 0);
    }
    
private:    
    bool isPossible(int mid, int k, int n, int budget, vector<vector<int>>& composition, vector<int>& stock, vector<int>& cost) {
        long long totalCost = 0;
        for (int i = 0; i < n; i++) {
            long long alloyReqd = 1LL * mid * composition[k][i];
            
            if (stock[i] >= alloyReqd) {
                
            } else {
                long long purchaseCost = 1LL * (alloyReqd - stock[i]) * cost[i];
                totalCost += purchaseCost;
            }
        }
        
        if (totalCost <= (long long) budget) {
            // cout << "totalCost: " << totalCost << "\t budget: " << budget << endl;
            
            return true;
        } else {
            // cout << "totalCost: " << totalCost << "\t budget: " << budget << endl;
            
            return false;
        }
        
    }
};