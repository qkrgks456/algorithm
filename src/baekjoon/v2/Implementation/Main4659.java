package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main4659 {
    public static void main(String[] args) throws Exception {
        List<Character> aeiou = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> etc = List.of('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k',
                'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            boolean check = isCheck(s, aeiou);
            if (check) {
                sb.append("<").append(s).append(">").append(" ").append("is").append(" ").append("acceptable.");
            } else {
                sb.append("<").append(s).append(">").append(" ").append("is").append(" ").append("not")
                        .append(" ")
                        .append("acceptable.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isCheck(String s, List<Character> aeiou) {
        boolean check = s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u");
        // 연속 3개 검증
        int aeiouCount = 0;
        int etcCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (aeiou.contains(s.charAt(i))) {
                etcCount = 0;
                aeiouCount++;
            } else {
                aeiouCount = 0;
                etcCount++;
            }
            if (aeiouCount == 3 || etcCount == 3) check = false;
        }
        // 같은 글자 연속 안됨, ee와 oo는 허용
        char before = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (before == s.charAt(i) && before != 'e' && before != 'o') {
                check = false;
            }
            before = s.charAt(i);
        }
        return check;
    }
}
