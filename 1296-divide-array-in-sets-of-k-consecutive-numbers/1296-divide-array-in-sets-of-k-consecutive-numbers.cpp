class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        map<int, int> freq;
        for (int num : nums) {
            freq[num]++;
        }

        for (auto entry : freq) {
            int el = entry.first;
            int count = entry.second;

            if (count == 0) continue;

            for (int i = 0; i < k; i++) {
                if (freq[el + i] < count) {
                    // cout << "el + i: " << el + 1 << endl;
                    return false;
                } else {
                    freq[el + i] -= count;
                }
            }
        }

        return true;
    }
};