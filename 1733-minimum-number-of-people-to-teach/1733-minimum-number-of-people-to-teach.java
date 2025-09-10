class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        Set<Integer>[] userLanguages = new HashSet[m];
        for (int i = 0; i < m; i++) {
            userLanguages[i] = new HashSet<>();
            for (int lang : languages[i]) {
                userLanguages[i].add(lang);
            }
        }

        Set<Integer> needsTeaching = new HashSet<>();
        for (int[] friendship : friendships) {
            int u1 = friendship[0] - 1;
            int u2 = friendship[1] - 1;

            if (!canCommunicate(userLanguages[u1], userLanguages[u2])) {
                needsTeaching.add(u1);
                needsTeaching.add(u2);
            }
        }

        if (needsTeaching.isEmpty()) {
            return 0;
        }

       
        int[] langFrequency = new int[n + 1];
        int maxFrequency = 0;
        for (int userIndex : needsTeaching) {
            for (int lang : userLanguages[userIndex]) {
                langFrequency[lang]++;
                maxFrequency = Math.max(maxFrequency, langFrequency[lang]);
            }
        }

        return needsTeaching.size() - maxFrequency;
    }

    private boolean canCommunicate(Set<Integer> languages1, Set<Integer> languages2) {
        if (languages1.size() > languages2.size()) {
            return canCommunicate(languages2, languages1);
        }
        for (int lang : languages1) {
            if (languages2.contains(lang)) {
                return true;
            }
        }
        return false;
    }
}