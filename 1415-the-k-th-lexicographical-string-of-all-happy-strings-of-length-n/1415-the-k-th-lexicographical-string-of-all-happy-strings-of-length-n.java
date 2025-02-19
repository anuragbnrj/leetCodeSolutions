class Solution {
    private int count;
    private String ans;

    public String getHappyString(int n, int k) {
        count = 0;
        ans = "";

        backtrack(0, new StringBuilder(), n, k);
        return ans;
    }

    private void backtrack(int idx, StringBuilder curr, int n, int k) {
        if (idx == n) {
            count += 1;

            if (count == k) {
                ans = curr.toString();
            }

            return;
        }

        if (idx == 0) {
            curr.append("a");
            backtrack(idx + 1, curr, n, k);
            curr.deleteCharAt(curr.length() - 1);

            curr.append("b");
            backtrack(idx + 1, curr, n, k);
            curr.deleteCharAt(curr.length() - 1);

            curr.append("c");
            backtrack(idx + 1, curr, n, k);
            curr.deleteCharAt(curr.length() - 1);
        } else {
            char prev = curr.charAt(curr.length() - 1);

            char[] arr = {'a', 'b', 'c'};
            for (int i = 0; i < 3; i++) {
                if (arr[i] != prev) {
                    curr.append(arr[i]);
                    backtrack(idx + 1, curr, n, k);
                    curr.deleteCharAt(curr.length() - 1);
                }
            }
        }
    }
}