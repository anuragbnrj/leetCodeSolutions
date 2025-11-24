class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        long curr = 0;
        List<Boolean> ans = new ArrayList<>();

        for (int num : nums) {
            curr = curr * 2 + num;

            if (curr % 5 == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;       
    }
}