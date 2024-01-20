
class Solution {
private:
    int MOD = 1000000007;

    vector<int> findNextSmallerIndices(vector<int> &arr) {
        int len = arr.size();
        vector<int> nseIndices(len, -1);
        stack<int> s;

        for (int i = 0; i < len; i++) {
            while (s.size() > 0 && arr[s.top()] > arr[i]) {
                int idx = s.top();
                s.pop();

                nseIndices[idx] = i;
            }

            s.push(i);
        }

        return nseIndices;
    }

    vector<int> findPreviousSmallerThanEqualIndices(vector<int> &arr) {
        int len = arr.size();
        vector<int> pstheIndices(len, -1);
        stack<int> s;

        for (int i = 0; i < len; i++) {
            while (s.size() > 0 && arr[s.top()] > arr[i]) {
                int idx = s.top();
                s.pop();
            }

            if (s.size() > 0) {
                pstheIndices[i] = s.top();
            }

            s.push(i);
        }

        return pstheIndices;
    }

public:
    int sumSubarrayMins(vector<int>& arr) {
        int len = arr.size();
        long long res = 0;
        vector<int> pstheIndices = findPreviousSmallerThanEqualIndices(arr);
        vector<int> nseIndices = findNextSmallerIndices(arr);

        for (int i = 0; i < len; i++) {
            long long prev = i - pstheIndices[i];
            long long next = 1LL;
            if (nseIndices[i] == -1) {
                next = len - i;
            } else {
                next = nseIndices[i] - i;
            }

            res = (res + (prev * next * arr[i])) % MOD;
        }

        return res;
    }
};