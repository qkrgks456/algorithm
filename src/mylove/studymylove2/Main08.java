package mylove.studymylove2;

import java.util.Locale;

public class Main08 {
    public static void main(String[] args) {
        String url = "http://WWW.CodeJohns.co.kr/join/index.html";
        // 1
        System.out.println(url);
        // 2
        System.out.println(url.length());
        // 3
        System.out.println(url.charAt(url.indexOf('t')));
        // 4
        System.out.println(url.indexOf("/"));
        // 5
        System.out.println(url.indexOf("/", 6));
        // 6
        System.out.println(url.lastIndexOf("/"));
        // 7
        System.out.println(url.substring(url.indexOf("j"), url.lastIndexOf("/")));
        // 8
        System.out.println(url.substring(url.lastIndexOf("/") + 1));
        // 9
        // Locale.ROOT <- 언어 상관없이
        System.out.println(url.toUpperCase(Locale.ROOT));
        // 10
        System.out.println(url.toLowerCase(Locale.ROOT));
        // 11
        System.out.println(url.substring(url.indexOf("W"), url.lastIndexOf("r") + 1).toLowerCase(Locale.ROOT));
    }
}
