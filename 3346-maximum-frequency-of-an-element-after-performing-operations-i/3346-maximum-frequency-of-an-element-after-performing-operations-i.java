class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int[] freq = new int[100005];

        Set<Integer> uniqueNums = new HashSet<>();
        int maxNum = 0;
        for (int num : nums) {
            freq[num] += 1;
            uniqueNums.add(num);
            maxNum = Math.max(maxNum, num);
        }

        int[] csum = new int[maxNum + 1];
        for (int i = 1; i <= maxNum; i++) {
            csum[i] = freq[i] + csum[i - 1];
        }
        
        int ans = 0;
        for (int i = 1; i <= maxNum; i++) {
            int num = i;
            int left = Math.max(1, num - k);
            int right = Math.min(maxNum, num + k);

            int totalElements = csum[right] - csum[left - 1];
            int exceptCurrent = totalElements - freq[num];
            int canBeConverted = Math.min(numOperations, exceptCurrent);

            ans = Math.max(ans, freq[num] + canBeConverted);
        }
        
        return ans;       
    }
}