class Solution {
    public int minNumberOperations(int[] target) {
        int len = target.length;
        
        int ans = target[0];
        for (int i = 0; i < len - 1; i++) {
            ans += Math.max(target[i + 1] - target[i], 0);
        }

        return ans;
    }
}