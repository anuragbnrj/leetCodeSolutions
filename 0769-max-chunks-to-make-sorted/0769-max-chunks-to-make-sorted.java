class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;

        int[] farthestSmaller = new int[len];
        for (int i = 0; i < len; i++) {
            int curr = arr[i];
            int farthestSmallerIdx = -1; 
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < curr) {
                    farthestSmallerIdx = j;
                }
            }

            farthestSmaller[i] = farthestSmallerIdx;
        }

        int partitions = 0;
        for (int i = 0; i < len; ) {
            // System.out.print("Before: " + i);
            if (farthestSmaller[i] == -1) {
                i += 1;
                partitions += 1;
            } else {
                int temp = farthestSmaller[i];
                for (int j = i; j < temp && j < len; j++) {
                    temp = Math.max(temp, farthestSmaller[j]);
                }

                i = temp + 1;
                partitions += 1;
            }

            // System.out.println(", After: " + i);
        }

        return partitions;
    }
}