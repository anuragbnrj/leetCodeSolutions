class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int len = weights.size();
        int beg = 1;
        int end = accumulate(weights.begin(), weights.end(), 0);

        while (beg < end) {
            int mid = beg + ((end - beg) / 2);

            if (!canShip(weights, days, mid)) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

private:
    bool canShip(vector<int>& weights, int days, int wtOfShip) {
        int len = weights.size();
        int daysTaken = 1;
        int totalWtOnADay = 0;
        for (int i = 0; i < len; i++) {
            if (weights[i] > wtOfShip) {
                return false;
            }
            if (totalWtOnADay + weights[i] <= wtOfShip) {
                totalWtOnADay += weights[i];
            } else {
                daysTaken++;
                totalWtOnADay = weights[i];
            }
        }

        if (daysTaken <= days) {
            return true;
        }
        return false;
    }
};