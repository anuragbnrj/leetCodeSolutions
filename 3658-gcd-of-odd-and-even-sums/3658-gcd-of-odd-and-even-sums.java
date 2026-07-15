class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int currOdd = 1;
        for (int i = 1; i <= n; i++) {
            sumOdd += currOdd;
            currOdd += 2;
        }

        int sumEven = 0;
        int currEven = 2;
        for (int i = 1; i <= n; i++) {
            sumEven += currEven;
            currEven += 2;
        }
        
        return gcd(sumEven, sumOdd);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}