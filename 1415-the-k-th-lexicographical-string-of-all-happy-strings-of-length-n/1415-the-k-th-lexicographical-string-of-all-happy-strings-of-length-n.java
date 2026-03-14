class Solution {
    private int count;
    private String ans;

    public String getHappyString(int n, int k) {
        count = 0;
        ans = "";

        StringBuilder sb = new StringBuilder();
        rec('z', sb, n, k);

        return ans;
    }

    private boolean rec(char prevChar, StringBuilder curr, int n, int k) {
        if (curr.length() == n) {
            count += 1;

            if (count == k) {
                ans = curr.toString();
                return true;
            } else {
                return false;
            }
        }

        char[] arr = {'a', 'b', 'c'};
        for (char ch : arr) {
            if (ch != prevChar) {
                curr.append(ch);
                boolean res = rec(ch, curr, n, k);
                curr.deleteCharAt(curr.length() - 1);

                if (res) return true;
            }
        }

        return false;
    }
}