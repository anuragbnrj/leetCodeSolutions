class Solution {
    boolean primesPopulated = false;
    boolean[] isPrime;

    public int[] closestPrimes(int left, int right) {
        if (!primesPopulated) {
            populatePrimes();
            primesPopulated = true;
        }

        int num1 = -1;
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                num1 = i;
                break;
            }
        }
        if (num1 == -1) {
            return new int[]{-1, -1};
        }

        int num2 = -1;
        for (int i = num1 + 1; i <= right; i++) {
            if (isPrime[i]) {
                num2 = i;
                break;
            }
        }
        if (num2 == -1) {
            return new int[]{-1, -1};
        }

        int minDiff = num2 - num1;
        int[] ans = {num1, num2};
        for (int i = num2 + 1; i <= right; i++) {
            if (isPrime[i]) {
                num1 = num2;
                num2 = i;

                if (num2 - num1 < minDiff) {
                    minDiff = num2 - num1;
                    ans = new int[]{num1, num2};
                }
            }
        }
        return ans;
        
    }

    private void populatePrimes() {
        int n = (int) 1e6 + 7;
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; (1L * i * i) <= (1L * n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

    }
}