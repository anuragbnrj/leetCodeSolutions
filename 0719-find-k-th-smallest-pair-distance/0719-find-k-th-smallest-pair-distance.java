class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        sortArray(nums);

        int beg = 0;
        int end = (int) 1e6;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            int pairs = findNoOfPairs(nums, mid);

            // System.out.println("mid: " + mid + ", pairs: " + pairs);

            if (pairs < k) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

    private int findNoOfPairs(int[] nums, int delta) {
        int n = nums.length;

        int pairs = 0;
        for (int i = 0; i < n; i++) {
            int find = nums[i] + delta;

            int beg = i, end = n;
            while (beg < end) {
                int mid = beg + (end - beg) / 2;

                if (nums[mid] <= find) beg = mid + 1;
                else end = mid;
            }

            pairs += (beg - i) - 1;
        }

        return pairs;
    }

    private void sortArray(int[] arr) {
        ArrayList<Integer> aList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            aList.add(arr[i]);
        }
        Collections.sort(aList);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = aList.get(i);
        }
    }
}