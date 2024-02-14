class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int len = nums.size();
        vector<int> pos, neg;
        for (int num : nums) {
            if (num > 0) {
                pos.push_back(num);
            } else {
                neg.push_back(num);
            }
        }

        vector<int> res;
        for (int i = 0; i < (int)pos.size(); i++) {
            res.push_back(pos[i]);
            res.push_back(neg[i]);
        }

        return res;
    }
};