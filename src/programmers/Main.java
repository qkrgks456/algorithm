package programmers;

import java.util.*;

public class Main {
    static int max;
    static char[] check;
    static char[] chars = new char[26];
    static List<Map<String, Integer>> list;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String s = "asd and tre and hfg 100";
        s = s.replaceAll(" and ","");
        String[] strings = s.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }

}

// 1 2 3 4 5
// 2 4 6 8 10
// 3
// 4
