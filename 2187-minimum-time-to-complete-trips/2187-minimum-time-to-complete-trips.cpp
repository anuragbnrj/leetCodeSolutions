typedef long long ll;

class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        ll beg = 0;
        ll end = 1e14 + 5;

        while (beg < end) {
            ll mid = beg + (end - beg) / 2;

            // cout << mid << endl;

            if (!check(time, totalTrips, mid)) beg = mid + 1;
            else end = mid;
        }

        return beg;        
    }

private:
    bool check(vector<int> &time, int totalTrips, ll mid) {
        int n = time.size();
        ll trips = 0;

        for (int i = 0; i < n; i++) {
            trips += (mid / (1LL * time[i]));
        }

        bool val = (trips >= totalTrips ? true : false);

        // cout << mid << ": " << val << endl;
        return val;
    }
};