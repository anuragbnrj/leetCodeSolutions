class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int len = items.length;

        int[][] itemsSorted = new int[len][2];
        for (int i = 0; i < len; i++) {
            itemsSorted[i] = items[i];
        }
        Arrays.sort(itemsSorted, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int maxTillNow = 0;
        for (int i = 0; i < len; i++) {
            maxTillNow = Math.max(maxTillNow, itemsSorted[i][1]);
            itemsSorted[i][1] = maxTillNow;
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int price = queries[i];
            int idx = findIdx(itemsSorted, price);
            
            ans[i] = idx == -1 ? 0 : itemsSorted[idx][1];
        }

        return ans;
    }

    private int findIdx(int[][] itemsSorted, int price) {
        int beg = 0;
        int end = itemsSorted.length;
        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (itemsSorted[mid][0] <= price) beg = mid + 1;
            else end = mid;
        }

        return beg - 1;
    }
}