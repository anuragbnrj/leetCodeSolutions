class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len = nums.length;

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            points.add(new Point(nums[i], i));
        }
        Collections.sort(points, (a, b) -> {
            return Integer.compare(a.val, b.val);
        });
        
        int prev = points.get(0).val;
        int[] ans = new int[len];
        PriorityQueue<Integer> indices = new PriorityQueue<>();
        PriorityQueue<Integer> values = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            Point curr = points.get(i);
            int val = curr.val;
            int idx = curr.idx;

            if (val - prev > limit) {
                while (!indices.isEmpty()) {
                    int top = indices.poll();
                    ans[top] = values.poll(); 
                }

                
            }

            prev = val;
            indices.add(idx);
            values.add(val);
        }
        while (!indices.isEmpty()) {
            int top = indices.poll();
            ans[top] = values.poll(); 
        }
        
        return ans;
    }

    class Point {
        int val;
        int idx;

        public Point(int _val, int _idx) {
            val = _val;
            idx = _idx;
        }
    }
}