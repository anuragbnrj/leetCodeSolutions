class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        int len = points.size();
        sort(points.begin(), points.end());

        vector<vector<int>> arrows;
        for (int i = 0; i < len; i++) {
            if ((int)arrows.size() == 0 || arrows.back()[1] < points[i][0]) {
                arrows.push_back(points[i]);
            } else {
                vector<int> back = arrows.back();
                arrows.pop_back();
                int obeg = max(back[0], points[i][0]);
                int oend = min(back[1], points[i][1]);
                arrows.push_back({obeg, oend});
            }
        }

        return (int)arrows.size();
    }
};