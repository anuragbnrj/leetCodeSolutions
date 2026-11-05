class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for (int n1 : arr1) {
            boolean flag = true;
            for (int n2 : arr2) {
                if (Math.abs(n1 - n2) <= d) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans += 1;
            }
        }

        return ans;
    }
}