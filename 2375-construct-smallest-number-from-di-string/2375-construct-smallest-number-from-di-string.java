class Solution {
    private String ans;

    public String smallestNumber(String pattern) {
        int patLen = pattern.length();
        int ansLen = patLen + 1;

        ans = "";
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < ansLen; i++) {
            ans += "9";
        }

        backtrack(0, pattern, ansLen, used, new StringBuilder());

        return ans;
    }

    private void backtrack(int idx, String pattern, int ansLen, Set<Integer> used, StringBuilder currSb) {
        if (idx == ansLen) {
            String curr = currSb.toString();

            // System.out.println(curr);
            if (curr.compareTo(ans) <= 0) {
                ans = curr;
            }

            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (idx == 0) {
                used.add(i);
                currSb.append(Integer.toString(i));
                backtrack(idx + 1, pattern, ansLen, used, currSb);
                currSb.deleteCharAt(currSb.length() - 1);
                used.remove(i);
            } else {
                int prev = currSb.charAt(currSb.length() - 1)- '0';

                if ((pattern.charAt(idx - 1) == 'D' && i < prev && !used.contains(i)) 
                || (pattern.charAt(idx - 1) == 'I' && i > prev && !used.contains(i))) {
                    used.add(i);
                    currSb.append(Integer.toString(i));
                    backtrack(idx + 1, pattern, ansLen, used, currSb);
                    currSb.deleteCharAt(currSb.length() - 1);
                    used.remove(i);
                }

            }
        }
    }
}