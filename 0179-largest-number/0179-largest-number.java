class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] strNums = new String[len];

        for (int i = 0; i < len; i++) {
            strNums[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> {
            int ptr1 = 0;
            int ptr2 = 0;

            String case1 = a + b;
            String case2 = b + a;

            return -1 * case1.compareTo(case2);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            // System.out.print(strNums[i] + ", ");
            sb.append(strNums[i]);
        }

        // Trim leading zeroes
        String ans = sb.toString();
        int idx = 0;
        int zeroCount = 0;
        while (idx < ans.length() && ans.charAt(idx) == '0') {
            zeroCount += 1;
            idx += 1;
        }
        if (zeroCount > 1) ans = ans.substring(zeroCount - 1);

        return ans;
    }
}