package programmers.problem.level1.level1_6;

public class Solution4 {
    public static String solution(String phone_number) {
        String s = phone_number.substring(0, phone_number.length() - 4);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append("*");
        }
        return stringBuilder.append(phone_number.substring(phone_number.length() - 4)).toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("dsgdfgdfgdfg"));
    }
}
