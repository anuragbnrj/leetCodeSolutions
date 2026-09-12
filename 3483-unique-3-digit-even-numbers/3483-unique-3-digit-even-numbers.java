class Solution {
    public int totalNumbers(int[] digits) {
        Map<Integer, Integer> digitsMap = new HashMap<>();

        for (int digit : digits) {
            int currCount = digitsMap.getOrDefault(digit, 0);
            digitsMap.put(digit, currCount + 1);
        }

        int ans = 0;
        for (int i = 100; i < 1000; i+=2) {
            int temp = i;
            Map<Integer, Integer> reqDigitsMap = new HashMap<>();

            while (temp > 0) {
                int r = temp % 10;
                temp /= 10;

                reqDigitsMap.put(r, reqDigitsMap.getOrDefault(r, 0) + 1);
            }

            boolean possible = true;
            for(Map.Entry<Integer, Integer> entry : reqDigitsMap.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();

                if (digitsMap.getOrDefault(key, 0) < val) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ans += 1;
            }
        }

        return ans;
    }
}