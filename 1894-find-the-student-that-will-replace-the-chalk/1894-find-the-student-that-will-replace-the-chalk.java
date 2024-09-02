class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long n = chalk.length;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
        }

        long rem = k % sum;
        for (int i = 0; i < n; i++) {
            if (chalk[i] > rem) {
                return i;
            }

            rem -= chalk[i];
        }
        
        return 0;
    }
}