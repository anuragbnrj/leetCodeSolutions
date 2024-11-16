class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        for ( ; i < k - 1; i++) {
            if (i != 0 && ((nums[i - 1] + 1) != nums[i])) {
                dq.addLast(i - 1);
            }

            int count = freq.getOrDefault(nums[i], 0);
            freq.put(nums[i], count + 1);
        }

        int left = 0;
        int right = i;
        for (; right < len; right++, left++) {
            int curr = nums[right];
            if (k > 1 && right != 0 && ((nums[right - 1] + 1) != curr)) {
                dq.addLast(right - 1);
            }
            int count = freq.getOrDefault(curr, 0);
            freq.put(curr, count + 1);

            System.out.println(right + ": " + dq.toString());

            if (dq.size() == 0) {
                ans[right - (k - 1)] = freq.lastKey();
            } else {
                ans[right - (k - 1)] = -1;
            }

            if (dq.size() > 0 && dq.peekFirst() == left) {
                dq.pollFirst();
            }
            int windowBeg = nums[left];
            count = freq.get(windowBeg);
            freq.put(windowBeg, count - 1);
            if (freq.get(windowBeg) == 0) {
                freq.remove(windowBeg);
            }
        }

        return ans;
    }
}