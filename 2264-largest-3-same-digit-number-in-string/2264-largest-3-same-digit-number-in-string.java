class Solution {
    public String largestGoodInteger(String num) {
        int len = num.length();

        String ans = "";
        for (int i = 2; i < len; i++) {
            String curr = num.substring(i - 2, i + 1);

            if (hasOneUnique(curr) && curr.compareTo(ans) > 0) {
                ans = curr;
            }
        }

        return ans;
    }

    private boolean hasOneUnique(String curr) {
        char prev = curr.charAt(0);

        for (int j = 1; j < 3; j++) {
            if (curr.charAt(j) != prev) {
                return false;
            }
        }

        return true;
    }
}