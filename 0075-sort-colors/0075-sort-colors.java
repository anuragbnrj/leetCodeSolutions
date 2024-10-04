class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int zeroPtr = 0, twoPtr = len - 1;

        int ptr = 0;
        while (ptr <= twoPtr) {
            if (nums[ptr] == 0) {
                int temp = nums[ptr];
                nums[ptr] = nums[zeroPtr];
                nums[zeroPtr] = temp;

                ptr += 1;
                zeroPtr += 1;
            } else if (nums[ptr] == 1) {
                ptr += 1;
            } else {
                int temp = nums[ptr];
                nums[ptr] = nums[twoPtr];
                nums[twoPtr] = temp;

                twoPtr -= 1;
            }
        }
        
    }
}