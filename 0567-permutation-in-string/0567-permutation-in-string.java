class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n2 < n1) {
            return false;
        }

        int[] freq1 = new int[26];
        for (int i = 0; i < n1; i++) {
            char ch = s1.charAt(i);

            freq1[ch - 'a'] += 1;
        }

        int[] freq2 = new int[26];
        for (int i = 0; i < n1 - 1; i++) {
            char ch = s2.charAt(i);

            freq2[ch - 'a'] += 1;
        }

        for (int right = n1 - 1, left = 0; right < n2; right++) {
            char ch = s2.charAt(right);
            freq2[ch - 'a'] += 1;

            boolean ans = true;
            for (int i = 0; i < 26; i++) {
                if (freq2[i] < freq1[i]) {
                    ans = false;
                    break;
                }
            }

            if (ans == true) {
                return ans;
            }

            ch = s2.charAt(left);
            freq2[ch - 'a'] -= 1;
            left += 1;
        }

        return false;
        
    }
}