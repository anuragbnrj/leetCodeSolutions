class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    if (Integer.bitCount(a) == Integer.bitCount(b)) {
                        return Integer.compare(a, b);
                    }

                    return Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}