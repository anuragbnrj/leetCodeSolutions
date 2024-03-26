class Solution {
public:
    int firstMissingPositive(vector<int>& a) {
        a.push_back(-1);

        int n = a.size() - 1;

        for (int i = 0; i <= n; i++) {
            int num = a[i];
            if (num == i) {
                continue;
            }

            while ((0 < num && num < i) || (i < num && num <= n)) {
                if (a[i] == a[a[i]]) {
                    break;
                }
                swap(a[i], a[a[i]]);
                num = a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (a[i] != i) {
                return i;
            }
        }

        return n + 1;
        
    }
};