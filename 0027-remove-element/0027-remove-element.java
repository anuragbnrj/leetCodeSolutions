class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;

        int freq = 0;
        int end = len - 1;
        for (int i = 0; i < len - freq; i++) {
            if (nums[i] == val) {
                freq++;

                while (end > 0 && end > i && nums[end] == val) {
                    end--;
                    freq++;
                }

                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            }
        }

        // for (int i = 0; i < len; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();
        // System.out.println(freq);
        
        return len - freq;
    }
}