class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int len = gas.size();
        int currSum = 0;
        int idx = 0;
        int total = 0;

        for (int i = 0; i < len; i++) {
            int currStation = (gas[i] - cost[i]);
            currSum += currStation;
            total += currStation;

            if (currSum < 0) {
                currSum = 0;
                idx = i + 1;   
            } 
        }

        if (total < 0) {
            return -1;
        } else {
            return idx;
        }
        
        
    }
};