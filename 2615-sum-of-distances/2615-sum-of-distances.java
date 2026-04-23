class Solution {
    public long[] distance(int[] nums) {
        int size = nums.length;

        Map<Integer, Integer> begFreqMap = new HashMap<>();
        Map<Integer, Integer> prevOccurrenceMap = new HashMap<>();
        long[] begIdxSum = new long[size];
        for (int i = 0; i < size; i++) {
            int num = nums[i];
            
            if (prevOccurrenceMap.containsKey(num)) {
                int prevOccurrence = prevOccurrenceMap.get(num);
                int freq = begFreqMap.getOrDefault(num, 0);
                long idxSum = begIdxSum[prevOccurrence];

                int diff = i - prevOccurrence;
                idxSum += (diff * freq);
                begIdxSum[i] = idxSum;
                freq += 1;
                begFreqMap.put(num, freq);
            } else {
                begFreqMap.put(num, 1);
            }

            prevOccurrenceMap.put(num, i);
        }


        Map<Integer, Integer> endFreqMap = new HashMap<>();
        prevOccurrenceMap = new HashMap<>();
        long[] endIdxSum = new long[size];
        for (int i = size - 1; i >= 0; i--) {
            int num = nums[i];
            
            if (prevOccurrenceMap.containsKey(num)) {
                int prevOccurrence = prevOccurrenceMap.get(num);
                int freq = endFreqMap.getOrDefault(num, 0);
                long idxSum = endIdxSum[prevOccurrence];

                int diff = prevOccurrence - i;
                idxSum += (diff * freq);
                endIdxSum[i] = idxSum;
                freq += 1;
                endFreqMap.put(num, freq);
            }else {
                
                endFreqMap.put(num, 1);
            }

            prevOccurrenceMap.put(num, i);
        }

        long[] ans = new long[size];
        for (int i = 0; i < size; i++) {
            int num = nums[i];

            ans[i] = begIdxSum[i] + endIdxSum[i];
        }
        
        return ans;
    }
}