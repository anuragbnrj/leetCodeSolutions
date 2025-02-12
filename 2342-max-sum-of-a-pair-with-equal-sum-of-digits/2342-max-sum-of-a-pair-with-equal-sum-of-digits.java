class Solution {
    public int maximumSum(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> sumOfDigitsMax = new HashMap<>();

        int ans = -1;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            int sumOfDigits = getSumOfDigits(curr);

            if (sumOfDigitsMax.containsKey(sumOfDigits)) {
                int complement = sumOfDigitsMax.get(sumOfDigits);

                ans = Math.max(ans, complement + curr);

                sumOfDigitsMax.put(sumOfDigits, Math.max(complement, curr));
            } else {
                sumOfDigitsMax.put(sumOfDigits, curr);
            }
        }

        return ans;
    }

    private int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;

            num /= 10;
        }

        return sum;
    }
}