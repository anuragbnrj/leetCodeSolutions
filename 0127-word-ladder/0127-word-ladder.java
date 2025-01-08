class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();

        Map<String, List<String>> adjList = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String currWord = wordList.get(i);
            adjList.put(currWord, new ArrayList<>());
            for (int j = 0; j < len; j++) {
                if (j == i) continue;

                String otherWord = wordList.get(j);

                if (differsByOne(currWord, otherWord)) {
                    List<String> neighbours = adjList.get(currWord);
                    neighbours.add(otherWord);

                }
            }
        }

        adjList.put(beginWord, new ArrayList<>());
        for (String otherWord : wordList) {
            if (differsByOne(beginWord, otherWord)) {
                List<String> neighbours = adjList.get(beginWord);
                neighbours.add(otherWord);
            }
        }

        int level = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (q.size() > 0) {
            level += 1;
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                String front = q.poll();

                if (front.equals(endWord)) {
                    return level;
                }

                for (String neighbour : adjList.get(front)) {
                    if (!visited.contains(neighbour)) {
                        q.offer(neighbour);
                        visited.add(neighbour);
                    } 
                }
            }
        }

        return 0;
    }

    private boolean differsByOne(String w1, String w2) {
        if (w1.length() != w2.length()) return false;

        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            if (c1 != c2) diff += 1;
        }

        if (diff == 1) return true;

        return false;
    }
}