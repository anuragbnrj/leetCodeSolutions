class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int size = arr.length;

        if (size == 0) return new int[]{};

        int[] temp = Arrays.copyOf(arr, size);
        Arrays.sort(temp);
        
        Map<Integer, Integer> rank = new HashMap<>();
        rank.put(temp[0], 1);
        int prev = temp[0];
        int currRank = 1;
        for (int i = 1; i < size; i++) {
            int curr = temp[i];

            if (curr == prev) {
                
            } else {
                currRank += 1;
                rank.put(curr, currRank);
                prev = curr;
            }
        }

        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = rank.get(arr[i]);
        }

        return ans;
    }
}