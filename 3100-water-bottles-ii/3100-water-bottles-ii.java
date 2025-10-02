class Solution {
    public int maxBottlesDrunk(int fullBottles, int numExchange) {
        int totalConsumed = 0;
        while (fullBottles >= numExchange) {
            // drink
            totalConsumed += numExchange;
            fullBottles -= numExchange;

            // exchange empty for full
            fullBottles += 1;

            // increase numExchange
            numExchange += 1;
        }

        return totalConsumed + fullBottles;
    }
}