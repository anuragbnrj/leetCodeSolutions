class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());

        vector<vector<int>> res;
        for (int i = 0; i < intervals.size(); i++) {
            int beg = intervals[i][0];
            int end = intervals[i][1];

            if (res.size() != 0) {
                if (res.back()[1] >= beg) {
                    res.back()[1] = max(res.back()[1], end);
                } else {
                    res.push_back({beg, end});
                }
            } else {
                res.push_back({beg, end});
            }
        }

        return res;
    }
};