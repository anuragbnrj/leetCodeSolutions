class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Set<Integer> mods = new HashSet<>();

        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            mods.add(mod);
        }

        int ans = -1;
        for (int i = 0; ans == -1; i++) {
            if (!mods.contains(i)) {
                ans = i;
            }
        }

        return ans;
    }
}