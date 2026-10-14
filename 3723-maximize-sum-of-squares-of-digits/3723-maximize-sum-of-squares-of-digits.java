class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > (num * 9)) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 9; i >= 0 && ans.length() < num; ) {

            if (sum >= i) {
                ans.append(Integer.toString(i));
                sum -= i;
            } else {
                i--;
            }
        }

        return ans.toString();
    }
}