class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> scoresMap = new HashMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            List<Integer> studentScores = scoresMap.getOrDefault(id, new ArrayList<Integer>());
            studentScores.add(score);
            scoresMap.put(id, studentScores);
        }

        int students = scoresMap.size();
        int[][] ans = new int[students][2];
        int idx = 0;
        for (Map.Entry<Integer, List<Integer>> scoresMapEntry : scoresMap.entrySet()) {
            int id = scoresMapEntry.getKey();
            List<Integer> studentScores = scoresMapEntry.getValue();

            Collections.sort(studentScores);
            Collections.reverse(studentScores);
            int top5Sum = 0;
            for (int j = 0; j < 5; j++) {
                top5Sum += studentScores.get(j);
            }

            ans[idx][0] = id;
            ans[idx][1] = top5Sum / 5;

            idx += 1;
        }

        Arrays.sort(ans, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        return ans;
    }
}