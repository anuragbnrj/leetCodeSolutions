class Solution {
    private String ans;

    public String findDifferentBinaryString(String[] nums) {
        ans = "";

        Set<String> present = new HashSet<>();
        for (String num : nums) {
            present.add(num);
        }

        int len = nums[0].length();

        StringBuilder sb = new StringBuilder();
        backtrack(0, sb, present, len);

        return ans;
    }

    private boolean backtrack(int idx, StringBuilder sb, Set<String> present, int len) {
        if (idx == len) {
            String curr = sb.toString();
            if (present.contains(curr)) {
                return false;
            }

            ans = curr;
            return true;
        }

        // 0 case
        boolean res = backtrack(idx + 1, sb.append("0"), present, len);
        if (res) return res;

        // clear 0
        sb.deleteCharAt(sb.length() - 1);

        // 1 case
        res = backtrack(idx + 1, sb.append("1"), present, len);
        sb.deleteCharAt(sb.length() - 1);

        return res;
    }
}