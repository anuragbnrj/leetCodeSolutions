class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;

        int count = 0;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            int next = nums[(i + 1) % len];

            if (curr > next) count++;
        }

        return (count <= 1);
    }
}