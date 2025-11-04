class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int len = nums.length;
        int[] freq = new int[51];

        int[] ans = new int[len - k + 1];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            freq[num] += 1;

            if (i >= k) {
                freq[nums[i - k]] -= 1;
            }

            if (i >= k - 1) {
                ans[idx] = getSumTopXDistinct(freq, x);
                idx += 1;
            }
        }

        return ans;
    }

    private int getSumTopXDistinct(int[] freq, int x) {
        PriorityQueue<int[]> topX = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i <= 50; i++) {
            if (freq[i] != 0) {
                topX.add(new int[]{freq[i], i});
            }

            if (topX.size() > x) {
                topX.poll();
            }
        }

        int sum = 0;
        while (topX.size() > 0) {
            int[] top = topX.poll();

            sum += top[0] * top[1];
        }

        return sum;
    }
}