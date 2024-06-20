class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        int beg = 0;
        int end = 1e9 + 1;
        sort(position.begin(), position.end());

        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            if (possible(position, m, mid)) beg = mid + 1;
            else end = mid;
        }

        return beg - 1;
    }

private:
    bool possible(vector<int> &position, int m, int mid) {
        int prev = position[0];
        int placed = 1;

        for (int i = 1; i < position.size(); i++) {
            if (position[i] - prev >= mid) {
                placed += 1;
                prev = position[i];
            }
        }

        if (placed >= m) {
            return true;
        } else {
            return false;
        }
    }

};