class Solution {
    public long sumAndMultiply(int n) {
        long x = 0, sum = 0, pow = 1, temp = n;

        while (temp > 0) {
            long r = temp % 10L;
            temp /= 10;

            if (r != 0) {
                x = r * pow + x;
                pow *= 10;
            }

            sum += r;
        }

        // System.out.println("x: " + x);
        // System.out.println("sum: " + sum);

        return x * sum;
    }
}