class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;

        int countFive = 0;
        int countTen = 0;
        for (int bill : bills) {
            if (bill == 5) {
                countFive += 1;
            } else if (bill == 10) {
                if (countFive < 1) {
                    return false;
                }
                countFive -= 1;
                countTen += 1;
            } else {
                if (countTen >= 1 && countFive >= 1) {
                    countFive -= 1;
                    countTen -= 1;
                    continue;
                }

                if (countFive >= 3) {
                    countFive -= 3;
                    continue;
                }

                return false;
            }
        }

        return true;
    }
}