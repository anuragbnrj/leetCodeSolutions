class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int len = nums.size();

        set<int> stt;

        for (int i = 0; i < len; i++) {
            if (stt.count(nums[i])) {

            } else {
                stt.insert(nums[i]);
            }
        }

        int idx = 0;
        for (auto &el : stt) {
            nums[idx++] = el;
        }

        return stt.size();
    }
};