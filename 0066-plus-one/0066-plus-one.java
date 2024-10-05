class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        List<Integer> ans = new ArrayList<>();

        int carry = 1;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            
            if (sum >= 10) {
                carry = sum / 10;
                ans.add(sum % 10);
            } else {
                carry = 0;
                ans.add(sum);
            }
        }
        if (carry > 0) {
            ans.add(carry);
        }

        Collections.reverse(ans);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}