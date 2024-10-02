class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        Integer[] boxedArr = new Integer[len];
        for (int i = 0; i < len; i++) {
            boxedArr[i] = arr[i];
        }
        Arrays.sort(boxedArr, (a, b) -> Integer.compare(a, b));
        
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int num : boxedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, ++rank);
            }
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        
        return result;
    }
}