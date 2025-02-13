class Solution {
    public int minOperations(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num * 1L);
        }

        int ops = 0;
        while(pq.peek() < k && pq.size() >= 2) {
            long top = pq.poll();
            long top2 = pq.poll();

            pq.offer(top * 2 + top2);
            ops += 1;
        }

        return ops;
    }
}