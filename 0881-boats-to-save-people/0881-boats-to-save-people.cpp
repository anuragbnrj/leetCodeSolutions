class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        int beg = 1;
        int end = people.size();
        sort(people.begin(), people.end());

        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            if (!check(people, limit, mid)) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

private:
    bool check(vector<int> &people, int limit, int mid) {
        int req = 0;

        for (int i = 0, j = people.size() - 1; i <= j; ) {
            if (i == j) {
                req++;
                i++;
                j--;
            } else {
                if (people[i] + people[j] <= limit) {
                    req++;
                    i++;
                    j--;
                } else {
                    req++;
                    j--;
                }
            }
        }

        return (req <= mid);
    }

};