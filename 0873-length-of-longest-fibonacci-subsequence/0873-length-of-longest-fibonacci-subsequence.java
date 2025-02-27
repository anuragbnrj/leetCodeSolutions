class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> elements = new HashSet<>();
        for (int num : arr) {
            elements.add(num);
        }

        Map<String, Integer> maxEndingAt = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int second = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int third = arr[j];
                int first = third - second;

                if (first >= second || second >= third) continue;
                // System.out.println("first: " + first + ", second: " + second + ", third: " + third);

                if (elements.contains(first)) {
                    String firstKey = first + "," + second;
                    String secondKey = second + "," + third;
                    int mx = Math.max(maxEndingAt.getOrDefault(secondKey, 0), maxEndingAt.getOrDefault(firstKey, 0) + 1);
                    // System.out.println(firstKey + ": " + maxEndingAt.getOrDefault(firstKey, 0) + ", "  + secondKey + ": " + mx);
                    maxEndingAt.put(secondKey, mx);
                }
            }
        }

        // System.out.println(maxEndingAt.toString());

        int ans = 0;
        for (int val : maxEndingAt.values()) {
            ans = Math.max(ans, val);
        }

        return ans + 2;
    }
}