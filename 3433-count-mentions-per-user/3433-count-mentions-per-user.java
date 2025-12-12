class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, (a, b) -> {
            int timestampA = Integer.parseInt(a.get(1));
            int timestampB = Integer.parseInt(b.get(1));
            if (timestampA == timestampB) {
                return b.get(0).compareTo(a.get(0));
            }

            return Integer.compare(timestampA, timestampB);
        });
        int[] mentions = new int[numberOfUsers];
        int[] offlineTime = new int[numberOfUsers];

        // ALL and HERE both will be added to this
        // To handle HERE case -1 will be added to count of those offline
        // Before returning, this count will be added to all the elements of the mentions array
        int globalMentions = 0; 
        for (List<String> event : events) {
            String eventType = event.get(0);
            Integer timestamp = Integer.parseInt(event.get(1));
            String ids = event.get(2);

            if (eventType.equals("OFFLINE")) {
                int offlineUserId = Integer.parseInt(ids);
                offlineTime[offlineUserId] = timestamp;
            } else {
                if (ids.equals("ALL")) {
                    globalMentions += 1;
                } else if (ids.equals("HERE")) {
                    globalMentions += 1;

                    for (int i = 0; i < numberOfUsers; i++) {
                        if (offlineTime[i] == 0) continue;

                        if (offlineTime[i] + 59 >= timestamp) {
                            mentions[i] -= 1;
                        } else {
                            offlineTime[i] = 0;
                        }
                    }
                } else {
                    String[] mentionIds = ids.split(" ");

                    for (String mentionId : mentionIds) {
                        int mentionUserId = Integer.parseInt(mentionId.substring(2));

                        mentions[mentionUserId] += 1; 
                    }
                }
            }
        }

        for (int i = 0; i < numberOfUsers; i++) {
            mentions[i] += globalMentions;
        }
        
        return mentions;
    }
}