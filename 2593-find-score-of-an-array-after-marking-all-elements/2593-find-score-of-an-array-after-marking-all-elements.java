class Solution {
    public long findScore(int[] nums) {
        int len = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val) {
                return Integer.compare(a.idx, b.idx);
            }

            return Integer.compare(a.val, b.val);
        });

        for (int i = 0; i < len; i++) {
            pq.offer(new Pair(nums[i], i));
        }
        boolean[] marked = new boolean[len];

        long score = 0;
        while (pq.size() > 0) {
            Pair top = pq.poll();
            int val = top.val;
            int idx = top.idx;

            if (marked[idx] == false) {
                int prevIdx = idx - 1;
                if (prevIdx >= 0) {
                    marked[prevIdx] = true;
                }

                int nextIdx = idx + 1;
                if (nextIdx < len) {
                    marked[nextIdx] = true;
                }

                score += val;
            }
        }

        return score;
    }

    class Pair {
        int val;
        int idx;

        public Pair(int _val, int _idx) {
            val = _val;
            idx = _idx;
        }
    }
}