class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);

        int totApples = 0;
        for (int a : apple) {
            totApples += a;
        }

        for (int i = capacity.length - 1; i >= 0; i--) {
            totApples -= capacity[i];
            if (totApples <= 0)
                return capacity.length - i;
        }

        return 0;
    }
}