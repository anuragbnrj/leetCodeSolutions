class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<>();
        for (List<String> entry : knowledge) {
            String key = entry.get(0);
            String val = entry.get(1);

            knowledgeMap.put(key, val);
        }
        
        StringBuilder ans = new StringBuilder();
        boolean isTemplate = false;
        StringBuilder templateKey = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                isTemplate = true;
            } else if (ch == ')') {
                ans.append(knowledgeMap.getOrDefault(templateKey.toString(), "?"));
                isTemplate = false;
                templateKey = new StringBuilder();
            } else {
                if (isTemplate) {
                    templateKey.append(Character.toString(ch));
                } else {
                    ans.append(Character.toString(ch));
                }
            }
        }

        return ans.toString();
    }
}