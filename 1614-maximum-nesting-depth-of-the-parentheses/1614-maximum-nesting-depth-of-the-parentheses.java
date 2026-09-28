class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int currDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currDepth += 1;
                ans = Math.max(ans, currDepth);
            } else if (ch == ')') {
                currDepth -= 1;
            }
        }
        
        return ans;
    }
}