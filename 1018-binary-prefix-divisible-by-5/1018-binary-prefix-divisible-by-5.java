class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        int curr = 0;
        List<Boolean> ans = new ArrayList<>();

        for (int num : nums) {
            curr = (curr * 2 + num);

            if (curr >= 10) curr = curr % 10;

            if (curr == 0 || curr == 5) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;       
    }
}