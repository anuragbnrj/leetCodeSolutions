struct Job {
    int startTime;
    int endTime;
    int profit;
};

bool cmp(const Job &j1, const Job &j2) { 
    return j1.endTime < j2.endTime; 
}

class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int len = startTime.size();
        vector<Job> jobs;

        for (int i = 0; i < len; i++) {
            Job j = {startTime[i], endTime[i], profit[i]};
            jobs.push_back(j);
        }
        
        sort(begin(jobs), end(jobs), cmp);
        vector<int> maxProfit(len, 0);
        
        maxProfit[0] = jobs[0].profit;
        int res = maxProfit[0];
        for (int i = 1; i < len; i++) {
            maxProfit[i] = jobs[i].profit;
            Job j = {-1, jobs[i].startTime, 10005};

            auto idx = upper_bound(jobs.begin(), jobs.end(), j, cmp) - jobs.begin();
            
            if(idx != 0 && (jobs[idx - 1].endTime <= jobs[i].startTime)) {
                maxProfit[i] = max(maxProfit[i], maxProfit[idx - 1] + jobs[i].profit);
            }

            maxProfit[i] = max(maxProfit[i], maxProfit[i - 1]);
            res = max(res, maxProfit[i]);
        }

        return res;
    }
};