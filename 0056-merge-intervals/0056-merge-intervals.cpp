class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int len = intervals.size();
        vector<pair<int, int>> arr(len);

        vector<vector<int>> res;

        for (int i = 0; i < len; i++) {
            int beg = intervals[i][0];
            int end = intervals[i][1];

            arr[i] = make_pair(beg, end);
        }

        sort(arr.begin(), arr.end());

        for (int i = 0; i < len; i++) {
            int beg = arr[i].first;
            int end = arr[i].second;

            for (int j = i + 1; j < len && arr[j].first <= end; j++) {
                i++;
                end = max(end, arr[j].second);
            }

            res.push_back({beg, end});
        }

        return res;
        
    }
};