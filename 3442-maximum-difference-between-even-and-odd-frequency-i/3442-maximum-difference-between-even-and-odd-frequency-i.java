class Solution {
    public int maxDifference(String s) {
        int maxOdd = 0, minEven = (int) 1e9;
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        // System.out.println(Arrays.toString(freq));

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            if (freq[i] % 2 == 0) {
                minEven = Math.min(minEven, freq[i]);
            } else {
                maxOdd = Math.max(maxOdd, freq[i]);
            }
        }

        return maxOdd - minEven;
    }
}