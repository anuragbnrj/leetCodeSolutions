class Solution {
    public long dividePlayers(int[] skill) {
        int len = skill.length;
        Integer[] boxedSkill = new Integer[len];
        for (int i = 0; i < len; i++) {
            boxedSkill[i] = skill[i];
        }
        Arrays.sort(boxedSkill, (a, b) -> {
            return Integer.compare(a, b);
        });

        int reqSkillSum = boxedSkill[0] + boxedSkill[len - 1];
        long chemistrySum = 0;
        for (int i = 0; i < len; i++) {
            int currSkillSum = boxedSkill[i] + boxedSkill[len - 1 - i];
            if (currSkillSum != reqSkillSum) {
                return -1L;
            }

            chemistrySum += 1L * boxedSkill[i] * boxedSkill[len - 1 - i];
        }

        return chemistrySum / 2;
    }
}