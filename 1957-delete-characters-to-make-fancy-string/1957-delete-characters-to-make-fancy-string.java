class Solution {
    public String makeFancyString(String s) {
        int len = s.length();
        if (len < 3) return s;

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(s.charAt(0)));
        sb.append(String.valueOf(s.charAt(1)));

        for (int i = 2; i < len; i++) {
            char curr = s.charAt(i);
            if (curr != s.charAt(i - 1) || curr != s.charAt(i - 2)) {
                sb.append(String.valueOf(curr));
            }
        }

        return sb.toString();
    }
}