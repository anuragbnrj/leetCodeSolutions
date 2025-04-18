class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String temp = countAndSay(n - 1);
        String ans = "";
        for (int i = 0; i < temp.length(); ) {
            char ch = temp.charAt(i);
            int currCount = 0;

            while (i < temp.length() && temp.charAt(i) == ch) {
                i++;
                currCount += 1;
            }

            ans += Integer.toString(currCount) + Character.toString(ch);
        }

        return ans;
    }
}