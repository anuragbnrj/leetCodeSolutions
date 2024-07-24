class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] ans = Arrays.stream(nums)
                .boxed()
                .sorted((x, y) -> {
                    return Integer.compare(mappedValue(x, mapping), mappedValue(y, mapping));
                })
                .mapToInt(i -> i)
                .toArray();

        return ans;
    }

    private int mappedValue(int num, int[] mapping) {
        int result = 0;
        int place = 1;
        if (num == 0) {
            return mapping[0];
        }
        while (num > 0) {
            int digit = num % 10;
            result += mapping[digit] * place;
            place *= 10;
            num /= 10;
        }
        return result;
    }
}