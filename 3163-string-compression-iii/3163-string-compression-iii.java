class Solution {
    public String compressedString(String word) {
        int len = word.length();

        char prev = word.charAt(0);
        int prevCount = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < len; i++) {
            char curr = word.charAt(i);
            if (curr == prev) {
                if (prevCount == 9) {
                    ans.append(Integer.toString(prevCount));
                    ans.append(prev);
                    prevCount = 1;
                } else {
                    prevCount += 1;
                }
            } else {
                ans.append(Integer.toString(prevCount));
                ans.append(prev);
                prev = curr;
                prevCount = 1;
            }
        }

        ans.append(Integer.toString(prevCount));
        ans.append(prev);

        return ans.toString();
    }
}