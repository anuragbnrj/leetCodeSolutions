class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int ans = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                ans += 1;
            }
        }

        return ans;
    }
}