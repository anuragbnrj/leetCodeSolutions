class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> freq(10004, 0);
        for (int num : nums) {
            if (num < 0) {
                freq[num * -1]++;
            } else {
                freq[num]++;
            }
        }

        vector<int> res;
        for (int i = 0; i < 10004; i++) {
            int f = freq[i];
            for (int j = 0; j < f; j++) {
                res.push_back(i * i);
            }
        }

        return res;
    }
    
};