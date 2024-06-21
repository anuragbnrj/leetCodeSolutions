class Solution {
public:
    int maxSatisfied(vector<int> &customers, vector<int> &grumpy, int minutes) {
        int n = customers.size();

        int currChange = 0;
        int maxChange = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            if (grumpy[end] == 1) {
                currChange += customers[end];
            }

            if (end - beg + 1 > minutes) {
                if (grumpy[beg] == 1) {
                    currChange -= customers[beg];
                }
                beg++;
            }

            if (end - beg + 1 == minutes) {
                if (currChange > maxChange) {
                    maxChange = currChange;
                }
            }
        }

        int satisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }
        satisfied += maxChange;

        return satisfied;
    }
};