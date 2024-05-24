class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int N = numbers.length;

        for (int beg = 0, end = N - 1; beg < end; ) {
            if (numbers[beg] + numbers[end] == target) {
                return new int[]{beg + 1, end + 1};
            }

            if (numbers[beg] + numbers[end] < target) {
                beg++;
            } else {
                end--;
            }
        }

        return new int[2];
    }
}