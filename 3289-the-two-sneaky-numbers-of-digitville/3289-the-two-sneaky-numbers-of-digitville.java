class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[100];

        List<Integer> ansList = new ArrayList<>();
        for (int num : nums) {
            freq[num] += 1;

            if (freq[num] == 2) {
                ansList.add(num);
            }
        }

        int[] ans = new int[2];
        ans[0] = ansList.get(0);
        ans[1] = ansList.get(1);

        return ans;   
    }
}