class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int len = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (Integer.compare(a[0], b[0]) == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for (int i = 0; i < len; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        while (k > 0) {
            int[] top = pq.poll();
            top[0] = top[0] * multiplier;

            pq.offer(top);
            k--;
        }

        int[] ans = new int[len];
        while (pq.size() > 0) {
            int[] top = pq.poll();

            ans[top[1]] = top[0];
        }
        
        return ans;
    }
}