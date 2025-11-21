class Solution {
    public int countPalindromicSubsequence(String s) {
        // 1. Find the first and last occurrence of every character
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == -1) {
                first[curr] = i;
            }
            last[curr] = i;
        }
        
        int ans = 0;
        
        // 2. Iterate over each character to use as the "shell" (outer characters)
        for (int i = 0; i < 26; i++) {
            // If the character doesn't exist or only exists once, it can't be a shell
            if (first[i] == -1 || last[i] == first[i]) {
                continue;
            }
            
            // 3. Find unique characters betweeen the first and last occurrence
            // Using a boolean array (or HashSet) to count unique chars
            boolean[] found = new boolean[26];
            int distinctCount = 0;
            
            // Iterate strictly between the first and last index of character 'i'
            for (int k = first[i] + 1; k < last[i]; k++) {
                int charIndex = s.charAt(k) - 'a';
                if (!found[charIndex]) {
                    found[charIndex] = true;
                    distinctCount++;
                    
                    // Optimization: If we found all 26 types in the middle, we can stop early
                    if (distinctCount == 26) break;
                }
            }
            
            ans += distinctCount;
        }
        
        return ans;
    }
}