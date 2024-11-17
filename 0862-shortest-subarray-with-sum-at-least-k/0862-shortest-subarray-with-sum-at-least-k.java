class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;

        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.getKey(), b.getKey());
        });

        long currSum = 0;
        int ans = (int) 1e9;
        for (int i = 0; i < len; i++) {
            currSum += nums[i];

            if (currSum >= k) {
                ans = Math.min(ans, i + 1);
            }

            while (pq.size() > 0 && (currSum - pq.peek().getKey()) >= k) {
                Pair<Long, Integer> top = pq.poll();

                ans = Math.min(ans, i - top.getValue());
            }

            pq.add(new Pair(currSum, i));
        }

        return (ans == (int) 1e9) ? -1 : ans;
    }
}