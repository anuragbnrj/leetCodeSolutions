class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] primes = getSieve(1005);

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (i == 0) {
                int nearestSmallerPrime = 0;
                for (int j = num - 1; j > 1; j--) {
                    if (primes[j] == true) {
                        nearestSmallerPrime = j;
                        break;
                    }
                }

                nums[i] = nums[i] - nearestSmallerPrime;
            } else {
                int diff = nums[i] - nums[i - 1];

                if (diff <= 0) {
                    return false;
                }

                int nearestSmallerPrime = 0;
                for (int j = diff - 1; j > 1; j--) {
                    if (primes[j] == true) {
                        nearestSmallerPrime = j;
                        break;
                    }
                }

                nums[i] = nums[i] - nearestSmallerPrime;

                if (nums[i] <= nums[i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean[] getSieve(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }

        // Initialize array with true values
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime numbers
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        // O(N log log N) - Sieve of Eratosthenes algorithm
        for (long i = 2; i * i <= n; i++) {
            if (isPrime[(int)i]) {
                for (long j = i * i; j <= n; j += i) {
                    isPrime[(int)j] = false;
                }
            }
        }

        return isPrime;
    }
}