class WordDistance {
    Map<String, List<Integer>> locations;
    Map<String, Integer> cache;

    public WordDistance(String[] words) {
        locations = new HashMap<>();
        cache = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> wordLocations = locations.getOrDefault(word, new ArrayList<>());
            wordLocations.add(i);
            locations.put(word, wordLocations);
        }
    }

    public int shortest(String word1, String word2) {
        String cacheKey = word1.compareTo(word2) < 0 ? word1 + ":" + word2 : word2 + ":" + word1;

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        List<Integer> locations1 = locations.get(word1);
        List<Integer> locations2 = locations.get(word2);

        int shortestDist = Integer.MAX_VALUE;
        for (int ptr1 = 0, ptr2 = 0; ptr1 < locations1.size() && ptr2 < locations2.size(); ) {
            int loc1 = locations1.get(ptr1);
            int loc2 = locations2.get(ptr2);

            shortestDist = Math.min(shortestDist, Math.abs(loc1 - loc2));

            if (loc1 < loc2) {
                ptr1++;
            } else {
                ptr2++;
            }
        }

        cache.put(cacheKey, shortestDist);
        return shortestDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */