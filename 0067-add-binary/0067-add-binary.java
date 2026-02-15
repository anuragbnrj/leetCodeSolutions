class Solution {
    public String addBinary(String a, String b) {
        String arev = reverse(a);
        String brev = reverse(b);
        
        int[] ans = new int[Math.max(arev.length(), brev.length())];
        int len = Math.min(arev.length(), brev.length());
        int carry = 0;
        int i;
        for (i = 0; i < len; i++) {
            int op1 = arev.charAt(i) - '0';
            int op2 = brev.charAt(i) - '0';

            int res = op1 + op2 + carry;

            if (res == 0) {
                ans[i] = 0;
                carry = 0;
            } else if (res == 1) {
                ans[i] = 1;
                carry = 0;
            } else if (res == 2) {
                ans[i] = 0;
                carry = 1;
            } else { // 3
                ans[i] = 1;
                carry = 1;
            }
        }

        for ( ; i < arev.length(); i++) {
            int op1 = arev.charAt(i) - '0';

            int res = op1 + carry;
            if (res == 0) {
                ans[i] = 0;
                carry = 0;
            } else if (res == 1) {
                ans[i] = 1;
                carry = 0;
            } else { // 2
                ans[i] = 0;
                carry = 1;
            }
        }

        for ( ; i < brev.length(); i++) {
            int op1 = brev.charAt(i) - '0';

            int res = op1 + carry;
            if (res == 0) {
                ans[i] = 0;
                carry = 0;
            } else if (res == 1) {
                ans[i] = 1;
                carry = 0;
            } else { // 2
                ans[i] = 0;
                carry = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        if (carry == 1) {
            sb.append("1");
        }
        
        
        return reverse(sb.toString());
    }

    private String reverse(String str) {
        int len = str.length();

        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}