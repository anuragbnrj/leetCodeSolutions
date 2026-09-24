class Solution {
    public int smallestIndex(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int num = nums[i];
            int sumOfDigits = getSumOfDigits(num);

            if (sumOfDigits == i) {
                return i;
            }
        }

        return -1;
    }

    private int getSumOfDigits(int num) {
        int sum = 0;

        while (num > 0) {
            int r = num % 10;
            num /= 10;

            sum += r;
        }

        return sum;
    }
}