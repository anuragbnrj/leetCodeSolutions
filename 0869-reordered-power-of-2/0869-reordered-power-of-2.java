class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<Long> powers = new ArrayList<>();
        long curr = 1;
        while (curr <= 1_000_000_000) {
            powers.add(curr);
            curr *= 2;
        }

        for (int i = 0; i < powers.size(); i++) {
            if (isAnagram(powers.get(i), n)) {
                return true;
            }
        }

        return false;
    }

    private boolean isAnagram(long power, int n) {
        String s1 = Long.toString(power);
        String s2 = Integer.toString(n);

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq = new int[10];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - '0']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i) - '0']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
