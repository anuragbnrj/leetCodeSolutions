class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        int beg = 1;
        int end = maxSum + 1;
        
        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            // cout << mid << endl;
            if (isPossible(mid, index, n, maxSum)) beg = mid + 1;
            else end = mid;
        }
        
        return beg - 1;
    }

private:
    bool isPossible(long long target, int k, int n, int maxSum) {
        long long lsum = 0;
        long long rsum = 0;
        long long finalSum = 0;

        if (target == (k + 1)) {
            lsum = (target * (target + 1)) / 2;
        } else if (target < (k + 1)) {
            lsum = (target * (target + 1)) / 2;
            lsum += ((k + 1) - target);
        } else {
            lsum = (target * (target + 1)) / 2;
            long long temp = target - (k + 1);
            long long tsum = (temp * (temp + 1)) / 2;
            lsum -= tsum;
        }

        if (target == (n - k)) {
            rsum = (target * (target + 1)) / 2;
        } else if (target < (n - k)) {
            rsum = (target * (target + 1)) / 2;
            rsum += ((n - k) - target);
        } else {
            rsum = (target * (target + 1)) / 2;
            long long temp = target - (n - k);
            long long tsum = (temp * (temp + 1)) /2;
            rsum -= tsum;
        }

        finalSum = lsum + rsum - target;
        // cout << "target: " << target << " finalSum: " << finalSum << endl;
        if (finalSum <= maxSum) {
            return true;
        }

        return false;
    }
};