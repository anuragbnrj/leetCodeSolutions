class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int len = nums.size();

        int k = 0;
        for (int i = 0; i < len; i++) {
            // int curr = nums[i];
            // int ctr = 1;
            // i++;
            
            // while (i < len && nums[i] == curr) {
            //     ctr++;
            //     i++;
            // }
            // i--;


            // if (ctr == 1) {
                
            // } else if (ctr == 2) {

            // } else {
            //     k = k + (ctr - 2);
            // }

            int ctr = 0;
            for (int j = i; j < len && (nums[j] == nums[i]); j++) {
                ctr++;
                if (ctr > 2) {
                    nums[j] = 1e9;
                } else {
                    k++; 
                }
            }

            i = i + ctr - 1;
        }

        sort(nums.begin(), nums.end());

        return k;
    }
};