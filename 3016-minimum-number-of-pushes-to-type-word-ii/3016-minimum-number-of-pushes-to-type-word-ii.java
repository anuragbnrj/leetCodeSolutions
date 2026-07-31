class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        int size = word.length();
        for (int i = 0; i < size; i++) {
            char ch = word.charAt(i);

            freq[ch - 'a'] += 1;
        }

        Arrays.sort(freq);

        int pressReqd = 0;
        int ans = 0;
        for (int i = 25, ctr = 0; i >= 0; i--, ctr++) {
            if (ctr % 8 == 0) pressReqd += 1;

            int curr = freq[i];
            ans += (curr * pressReqd);
        }

        return ans;
    }
}