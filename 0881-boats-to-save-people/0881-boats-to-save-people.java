class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int res = 0;
        for (int i = 0, j = people.length - 1; i <= j; ) {
            if (i == j) {
                res++;
                i++;
                j--;
            } else {
                if (people[i] + people[j] <= limit) {
                    res++;
                    i++;
                    j--;
                } else {
                    res++;
                    j--;
                }
            }
        }

        return res;
    }
}