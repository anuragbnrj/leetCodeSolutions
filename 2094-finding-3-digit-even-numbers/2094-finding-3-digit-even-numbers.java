class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int len = digits.length;

        Set<Integer> satNums = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (digits[i] % 2 == 1) continue;
            
            for (int j = 0; j < len; j++) {
                if (j == i) continue;

                for (int k = 0; k < len; k++) {
                    if (k == j || k == i || digits[k] == 0) continue;
                    int num = digits[i] + digits[j] * 10 + digits[k] * 100;

                    satNums.add(num);
                }
            }
        }

        int[] result = new int[satNums.size()];
        int idx = 0;
        for (int num : satNums) {
            result[idx] = num;
            idx += 1;
        }

        Arrays.sort(result);
        return result;
    }
}