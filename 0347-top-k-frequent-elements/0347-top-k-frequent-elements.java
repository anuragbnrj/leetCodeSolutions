class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.merge(num, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        // System.out.println(freq.toString());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            pq.offer(new int[]{key, value});

            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        int idx = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            ans[idx++] = top[0];
        }

        return ans;
    }
}