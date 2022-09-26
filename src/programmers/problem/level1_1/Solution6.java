package programmers.problem.level1_1;

public class Solution6 {
    public int solution(String s) {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < strings.length; i++) {
            s = s.replaceAll(strings[i], Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}
