class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        map<int, int> freq;
        int len = logs.size();

        for (int i = 0; i < logs.size(); i++) {
            int birth = logs[i][0];
            int death = logs[i][1];

            freq[birth]++;
            freq[death]--;
        }

        int currPop = 0;
        int maxPop = INT_MIN;
        int maxPopYear = 0;
        for (auto el : freq) {
            int year = el.first;
            currPop += el.second;

            if (currPop > maxPop) {
                maxPop = currPop;
                maxPopYear = year;
            }
        }
        
        return maxPopYear;
    }
};