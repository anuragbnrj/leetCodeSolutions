class Solution {
    public int countSeniors(String[] details) {
        int n = details.length;

        int ans = 0;
        for (String detail : details) {
            char[] detailArr = detail.toCharArray();

            String ageStr = detailArr[11] + "" + detailArr[12];
            int age = Integer.parseInt(ageStr);

            if (age > 60) {
                ans += 1;
            }
        }

        return ans;
    }
}