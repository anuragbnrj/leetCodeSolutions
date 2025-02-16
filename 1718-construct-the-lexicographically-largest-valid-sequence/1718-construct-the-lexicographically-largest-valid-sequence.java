class Solution {
    private int[] arr;
    private int[] ans;
    private boolean[] used;
    
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        arr = new int[len];
        Arrays.fill(arr, -1);
        ans = new int[len];
        used = new boolean[n + 1];

        backtrack(0, n, len);

        return ans;
    }

    private boolean backtrack(int index, int n, int len) {
        if (index == len) {
            System.arraycopy(arr, 0, ans, 0, len);
            return true;
        }

        if (arr[index] != -1) {
            return backtrack(index + 1, n, len);
        }

        for (int num = n; num >= 1; num--) {
            if (!used[num]) {
                int secondIndex = (num == 1) ? -1 : index + num;

                if (num == 1 || (secondIndex < len && arr[secondIndex] == -1)) {
                    arr[index] = num;
                    if (num > 1) arr[secondIndex] = num;
                    used[num] = true;

                    if (backtrack(index + 1, n, len)) return true; 

                    arr[index] = -1;
                    if (num > 1) arr[secondIndex] = -1;
                    used[num] = false;
                }
            }
        }

        return false;
    }
}