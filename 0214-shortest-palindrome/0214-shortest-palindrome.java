class Solution {

    long mod = (long) 1e9 + 7;
    long prime = (long) 1e9 + 9;

    public String shortestPalindrome(String s) {
        int len = s.length();
        long[] primePowers = getPrimePowers(len);

        long[] rollingHash = new long[len];
        long currentHash = 0;
        for (int i = 0; i < len; i++) {
            int charVal = s.charAt(i) - 'a' + 1;

            currentHash = (currentHash * prime) % mod + charVal;
            rollingHash[i] = currentHash;
        }

        currentHash = 0;
        for (int i = len - 1; i >= 0; i--) {
            int charVal = s.charAt(i) - 'a' + 1;

            currentHash = (currentHash * prime) % mod + charVal; 
        }

        int commonLength = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (rollingHash[i] == currentHash) {
                commonLength = i + 1;
                break;
            }

            int charVal = s.charAt(i) - 'a' + 1;
            currentHash = (currentHash - (primePowers[i] * charVal)) % mod;
            currentHash = (currentHash + mod) % mod; 
        }

        String notCommon = s.substring(commonLength);
        String reverseNotCommon = reverse(notCommon);
        // System.out.println("notCommon: " + notCommon + ", reverseNotCommon: " + reverseNotCommon);

        return reverseNotCommon + s;
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();

        int len = str.length();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    private long[] getPrimePowers(int len) {
        long[] powers = new long[len + 1];
        long pow = 1;
        
        for (int i = 0; i <= len; i++) {
            powers[i] = pow;
            pow = (pow * prime) % mod;
        }

        return powers;
    }
}