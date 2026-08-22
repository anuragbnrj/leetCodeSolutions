class Solution {
    public boolean checkDivisibility(int n) {
        int digSum = 0, digProd = 1;

        int temp = n;
        while (temp > 0) {
            int rem = temp % 10;

            digSum += rem;
            digProd *= rem;

            temp /= 10;
        }

        return (n % (digSum + digProd)) == 0;
    }
}