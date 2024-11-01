class Solution {
    public String makeFancyString(String s) {
        int len = s.length();

        char prev = s.charAt(0);
        int prevCount = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < len; i++) {
            char curr = s.charAt(i);

            if (curr == prev) {
                prevCount += 1;
            } else {
                prevCount = prevCount > 2 ? 2 : prevCount;
                for (int j = 0; j < prevCount; j++) {
                    ans.append(prev);
                }

                prev = curr;
                prevCount = 1;
            }
        }

        prevCount = prevCount > 2 ? 2 : prevCount;
        for (int j = 0; j < prevCount; j++) {
            ans.append(prev);
        }
        
        return ans.toString();
    }
}