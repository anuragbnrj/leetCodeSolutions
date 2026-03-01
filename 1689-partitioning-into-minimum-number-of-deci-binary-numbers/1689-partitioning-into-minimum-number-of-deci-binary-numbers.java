class Solution {
    public int minPartitions(String n) {
        int len = n.length();

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int digit = n.charAt(i) - '0';
            ans = Math.max(ans, digit);
        }

        return ans;
    }
}