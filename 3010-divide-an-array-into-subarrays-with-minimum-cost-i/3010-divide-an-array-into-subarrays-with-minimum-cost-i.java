class Solution {
    public int minimumCost(int[] nums) {
        int len = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });

        for (int i = 1; i < len; i++) {
            int curr = nums[i];

            pq.offer(nums[i]);

            if (pq.size() > 2) {
                pq.poll();
            }
        }

        int ans = 0;
        while (pq.size() > 0) {
            int top = pq.poll();
            ans += top;
        }
        ans += nums[0];       

        return ans;
    }
}