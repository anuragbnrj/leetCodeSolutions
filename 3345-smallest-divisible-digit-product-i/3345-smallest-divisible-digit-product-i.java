class Solution {
    public int smallestNumber(int n, int t) {
        int iter = n;
        boolean found = false;
        
        int ans = 0;
        while (!found) {
            int temp = iter;
            int prodOfDig = 1;

            while (temp > 0) {
                int r = temp % 10;
                temp /= 10;
                prodOfDig *= r;
            }

            if (prodOfDig % t == 0) {
                found = true;
                ans = iter;
            }

            iter += 1;
        }
        
        return ans;
    }
}