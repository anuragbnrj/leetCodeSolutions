class Solution {
    public boolean judgeCircle(String moves) {
        int hor = 0, ver = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                ver += 1;
            } else if (ch == 'D') {
                ver -= 1;
            } else if (ch == 'L') {
                hor -= 1;
            } else if (ch == 'R') {
                hor += 1;
            }
        }

        if (hor == 0 && ver == 0) {
            return true;
        }
        return false;
    }
}