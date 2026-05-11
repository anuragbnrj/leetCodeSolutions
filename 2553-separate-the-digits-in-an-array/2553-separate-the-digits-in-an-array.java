class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ansList = new ArrayList<>();

        for (int num : nums) {
            String numStr = Integer.toString(num);

            for (char ch : numStr.toCharArray()) {
                ansList.add(ch - '0');
            }
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}