class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> recipesSet = new HashSet<>(Arrays.asList(recipes));
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));

        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> dependsOn = ingredients.get(i);
            indegree.put(recipe, dependsOn.size());
            for (String ingredient : dependsOn) {
                adjList.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (String supply : supplies) {
            q.offer(supply);
        }

        Set<String> ansSet = new HashSet<>();

        while (!q.isEmpty()) {
            String front = q.poll();

            if (recipesSet.contains(front)) {
                ansSet.add(front);
            }

            if (adjList.containsKey(front)) { 
                for (String neigh : adjList.get(front)) {
                    indegree.put(neigh, indegree.get(neigh) - 1);
                    if (indegree.get(neigh) == 0) {
                        q.offer(neigh);
                    }
                }
            }
        }

        return new ArrayList<>(ansSet);
    }
}