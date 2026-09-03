class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true, allOdd = true;
        int smallest = Integer.MAX_VALUE;

        for (int num : nums1) {
            allEven = allEven & (num % 2 == 0);
            allOdd = allOdd & (num % 2 == 1);

            smallest = Math.min(smallest, num);
        }

        if (allEven || allOdd) {
            return true;
        }

        return (smallest % 2 == 1);
    }
}