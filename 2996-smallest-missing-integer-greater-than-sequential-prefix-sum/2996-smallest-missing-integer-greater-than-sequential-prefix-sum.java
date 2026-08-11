class Solution {
    public int missingInteger(int[] nums) {
        int endsAt = 0;

        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i + 1] == (nums[i] + 1)) {
                endsAt += 1;
            } else {
                break;
            }
        }

        int seqPrefixSum = 0;
        for (int i = 0; i <= endsAt; i++) {
            seqPrefixSum += nums[i];
        }

        System.out.println("seqPrefixSum: " + seqPrefixSum);
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
        }

        for (int i = seqPrefixSum; ; i++) {
            if (!present.contains(i)) {
                return i;
            }
        }
    }
}