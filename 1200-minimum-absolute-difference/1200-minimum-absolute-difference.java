class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int len = arr.length;  
        Arrays.sort(arr);

        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            int currDiff = arr[i + 1] - arr[i];

            minAbsDiff = Math.min(minAbsDiff, currDiff);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (arr[i + 1] - arr[i] == minAbsDiff) {
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        
        return ans;
    }
}