class Solution {
    public String addSpaces(String s, int[] spaces) {
        int idx = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces.length; i++) {
            int desIdx = spaces[i];

            while (idx < desIdx) {
                sb.append(s.charAt(idx));
                idx += 1;
            }

            sb.append(" ");
            sb.append(s.charAt(idx));
            idx += 1;
        }

        while (idx < s.length()) {
            sb.append(s.charAt(idx));
            idx += 1; 
        }


        return sb.toString();
    }
}