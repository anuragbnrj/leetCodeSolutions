class Solution {
    public int numSteps(String s) {
        List<Character> charList = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        int ans = 0;
        while (charList.size() > 1) {
            char lastChar = charList.get(charList.size() - 1);

            if (lastChar == '0') {
                charList.remove(charList.size() - 1);
            } else {
                addOne(charList);
            }

            ans += 1;
        }

        return ans;
    }

    private void addOne(List<Character> charList) {
        int i = charList.size() - 1;
        int carry = 1; 

        while (i >= 0 && carry == 1) {
            char c = charList.get(i);
            if (c == '0') {
                charList.set(i, '1');
                carry = 0;
            } else {
                charList.set(i, '0');
                
            }
            i--;
        }

        if (carry == 1) {
            charList.add(0, '1');
        }
    }
}