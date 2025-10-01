class Solution {
    public int numWaterBottles(int fullBottles, int numExchange) {
        int drunk = 0;

        int emptyBottles = 0;
        while (fullBottles > 0) {
            drunk += fullBottles;

            int newDrinks = (fullBottles + emptyBottles) / numExchange;
            emptyBottles = (fullBottles + emptyBottles) % numExchange;

            fullBottles = newDrinks;
        }

        return drunk;
    }
}