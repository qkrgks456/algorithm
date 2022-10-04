package programmers.problem.level1_6;

public class Solution4 {
    public static String solution(String phone_number) {
        return phone_number.substring(0, phone_number.length() - 4);
    }

    public static void main(String[] args) {
        System.out.println(solution("dsgdfgdfgdfg"));
    }
}
