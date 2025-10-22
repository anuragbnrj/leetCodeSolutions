class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> freq = new HashMap<>();

        List<int[]> events = new ArrayList<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            events.add(new int[]{num - k, 1});
            events.add(new int[]{num, 2});
            events.add(new int[]{num + k, 3});
        }

        Collections.sort(events, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int ans = 0;
        int redCount = 0;
        for (int[] event : events) {
            int val = event[0];
            int type = event[1];

            if (type == 1) {
                redCount += 1;
            }

            if (type == 3) {
                redCount -= 1;
            }

            ans = Math.max(ans, freq.getOrDefault(val, 0) + Math.min(redCount - freq.getOrDefault(val, 0), numOperations));
        }
        
        return ans;
    }
}