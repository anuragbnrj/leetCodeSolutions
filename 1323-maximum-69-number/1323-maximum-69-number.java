class Solution {
    public int maximum69Number (int num) {
        String numStr = Integer.toString(num);

        StringBuilder ans = new StringBuilder();
        boolean changed = false;
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);

            if (ch == '6' & !changed) {
                ans.append('9');
                changed = true;
            } else {
                ans.append(ch);
            }
        }

        return Integer.parseInt(ans.toString());
    }
}