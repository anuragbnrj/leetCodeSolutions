class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (!present.contains(num - 1)) {
                int len = 0;
                int temp = num;

                while (present.contains(temp)) {
                    len++;
                    temp += 1;
                }
                res = Math.max(res, len);
            }
            
        }

        return res;
    }
}