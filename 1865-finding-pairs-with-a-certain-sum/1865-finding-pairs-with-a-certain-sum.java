class FindSumPairs {

    int[] nums1;
    TreeMap<Integer, Integer> freq1 = new TreeMap<>();
    int[] nums2;
    TreeMap<Integer, Integer> freq2 = new TreeMap<>();

    public FindSumPairs(int[] n1, int[] n2) {
        int len1 = n1.length;
        nums1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            nums1[i] = n1[i];
            freq1.put(nums1[i], freq1.getOrDefault(nums1[i], 0) + 1);
        }

        int len2 = n2.length;
        nums2 = new int[len2];
        for (int i = 0; i < len2; i++) {
            nums2[i] = n2[i];
            freq2.put(nums2[i], freq2.getOrDefault(nums2[i], 0) + 1);
        }
    }

    public void add(int idx, int val) {
        int currVal = nums2[idx];
        int nextVal = currVal + val;

        freq2.put(currVal, freq2.getOrDefault(currVal, 0) - 1);
        freq2.put(nextVal, freq2.getOrDefault(nextVal, 0) + 1);

        nums2[idx] = nextVal;
    }

    public int count(int tot) {
        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
            int key = entry.getKey();
            if (key >= tot) break;

            int val = entry.getValue();
            ans += val * freq2.getOrDefault(tot - key, 0);
        }

        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */