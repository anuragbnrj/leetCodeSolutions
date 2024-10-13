class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        int k = nums.size();
        
        for (int i = 0; i < k; i++) {
            List<Integer> curr = nums.get(i);
            for (Integer num : curr) {
                list.add(new int[]{num, i});
            }
        }
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        Map<Integer, Integer> freq = new HashMap<>();
        int n = list.size();
        int ansRange = (int) 1e9;
        int ansLeft = 0, ansRight = 0;
        
        for (int left = 0, right = 0; right < n; right++) {
            int[] curr = list.get(right);
            int el = curr[0];
            int listNum = curr[1];
            freq.put(listNum, freq.getOrDefault(listNum, 0) + 1);

            while (freq.size() == k) {
                int currLeft = list.get(left)[0];
                int currRight = list.get(right)[0];
                int currRange = currRight - currLeft;

                if (currRange < ansRange) {
                    ansRange = currRange;
                    ansLeft = currLeft;
                    ansRight = currRight;
                }

                int currLeftListNum = list.get(left)[1];
                freq.put(currLeftListNum, freq.get(currLeftListNum) - 1);
                if (freq.get(currLeftListNum) == 0) {
                    freq.remove(currLeftListNum);
                }
                left += 1;
            }
        }
        
        return new int[]{ansLeft, ansRight};
    }
}