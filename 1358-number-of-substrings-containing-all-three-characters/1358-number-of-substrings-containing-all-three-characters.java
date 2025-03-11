class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();

        int left = 0;
        int right = -1;

        Map<Character, Integer> freq = new HashMap<>();
        int ans = 0;
        while (left < len) {

            while (right + 1 < len && freq.size() < 3) {
                right += 1;
                char rightChar = s.charAt(right);
                freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            }

            if (freq.size() == 3) {
                ans += (len - right);
            }

            if (left <= right) {
                char leftChar = s.charAt(left);
                int leftCharFreq = freq.get(leftChar);
                if (leftCharFreq == 1) {
                    freq.remove(leftChar);
                } else {
                    freq.put(leftChar, leftCharFreq - 1);
                }

                left += 1;
            } else {
                left += 1;
                right = left - 1;
            }
        }

        return ans;
    }
}