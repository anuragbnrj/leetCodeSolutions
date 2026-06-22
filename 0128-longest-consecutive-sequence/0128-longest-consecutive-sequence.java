class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> present = new HashSet<>();

        for (int num : nums) {
            present.add(num);
        }

        int ans = 0;
        for (int num : present) {
            int prev = num - 1;
            if (!present.contains(prev)) {
                int req = num;
                int currLen = 0;    
                while (present.contains(req)) {
                    currLen += 1;
                    req += 1;
                }

                ans = Math.max(ans, currLen);
            }
        }

        return ans;
    }
}