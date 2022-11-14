package programmers.problem.level2.level2_5;

public class Solution4 {

    public static int solution(String skill, String[] skill_trees) {
        String[] skills = skill.split("");
        int result = 0;
        for (String skill_tree : skill_trees) {
            int n = 0;
            String[] strings = skill_tree.split("");
            boolean check = true;
            for (int i = 0; i < strings.length; i++) {
                if (!skill.contains(strings[i])) continue;
                if (!strings[i].equals(skills[n])) {
                    check = false;
                    break;
                }
                n++;
                if (n == skills.length) break;
            }
            if (check) result++;
        }
        return result;
    }

}
