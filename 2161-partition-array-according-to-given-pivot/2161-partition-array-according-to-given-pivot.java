class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] temp = new int[len];

        int lt = 0, eq = 0, gt = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            temp[i] = num;
            if (num < pivot) {
                lt += 1;
            } else if (num == pivot) {
                eq += 1;
            } else {
                gt += 1;
            }
        }

        int idxlt = 0, idxeq = lt, idxgt = lt + eq;
        for (int i = 0; i < len; i++) {
            int num = temp[i];
            if (num < pivot) {
                nums[idxlt++] = num;
            } else if (num == pivot) {
                nums[idxeq++] = num;
            } else {
                nums[idxgt++] = num;
            }
        }

        return nums;
    }
}