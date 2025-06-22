class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int grps = (int) Math.ceil((1.0 * len) / k);
        
        int idx = 0;
        String[] ans = new String[grps];
        for (int grp = 0; grp < grps; grp++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++, idx++) {
                if (idx >= len) {
                    sb.append(fill);
                } else {
                    sb.append(s.charAt(idx));
                }
            }

            ans[grp] = sb.toString();
        }

        return ans;
    }
}