package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main17413 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] strings = str.split("");
        List<String> stringList = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean check = true;
        for (String s : strings) {
            if (s.equals("<")) {
                result.append(reverseStr(stringList));
                stringList.clear();
                result.append("<");
                check = false;
                continue;
            }
            if (s.equals(">")) {
                result.append(">");
                check = true;
                continue;
            }
            if (check) {
                if (s.equals(" ")) {
                    result.append(reverseStr(stringList));
                    result.append(" ");
                    stringList.clear();
                } else {
                    stringList.add(s);
                }
            } else {
                result.append(s);
            }
        }
        result.append(reverseStr(stringList));
        System.out.println(result);
    }

    public static String reverseStr(List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.reverse(strings);
        for (String s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
