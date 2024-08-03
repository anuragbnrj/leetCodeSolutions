class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = arr.length;
        int[] freqArr = new int[1001];
        int[] freqTarget = new int[1001];

        for (int i = 0; i < n; i++) {
            freqArr[arr[i]] += 1;
            freqTarget[target[i]] += 1;
        }

        for (int i = 1; i <= 1000; i++) {
            if (freqArr[i] != freqTarget[i]) {
                return false;
            }
        }

        return true;        
    }
}