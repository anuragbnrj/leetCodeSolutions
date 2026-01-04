class Solution {
    public int sumFourDivisors(int[] nums) {
        int len = nums.length;

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int sqrt = (int) Math.sqrt(num);

            int divisors = 0;
            int tempSum = 0;
            for (int div = 2; div <= sqrt; div++) {
                if (num % div == 0) {
                    if (div * div == num) {
                        divisors += 1;
                        tempSum += div;
                    } else {
                        divisors += 2;
                        tempSum += div + (num / div);
                    }
                }
            }

            if (divisors == 2) {
                ans += tempSum + 1 + num;
            }

        }
         
        return ans;
    }
}