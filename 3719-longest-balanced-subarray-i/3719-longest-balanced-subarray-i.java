class Solution {
    public int longestBalanced(int[] nums) {
        int len = nums.length;

        int ans = 0;
        for (int beg = 0; beg < len; beg++) {
            Map<Integer, Integer> even = new HashMap<>();
            Map<Integer, Integer> odd = new HashMap<>();

            for (int end = beg; end < len; end++) {
                int curr = nums[end];
                if (curr % 2 == 0) {
                    even.put(curr, even.getOrDefault(curr, 0) + 1);
                } else {
                    odd.put(curr, odd.getOrDefault(curr, 0) + 1);
                }

                if (even.size() == odd.size()) {
                    ans = Math.max(ans, end - beg + 1);
                }
            }
        }

        return ans;
    }
}