class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int len = nums.size();

        int k = 0; 
        for (int i = 0; i < len; i++) {
            if (i < 2 || nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
};