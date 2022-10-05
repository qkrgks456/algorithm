package programmers.problem.level1.level1_6;

public class Solution5 {
    public String solution(String[] seoul) {
        int result = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                result = i;
                break;
            }
        }
        return "김서방은 " + result + "에 있다";
    }
}
