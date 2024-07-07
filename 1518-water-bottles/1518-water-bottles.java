class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            drunk += (empty / numExchange);
            empty = (empty / numExchange) + (empty % numExchange);
        }

        return drunk;
    }
}