package programmers;

public class Main {


    public static void main(String[] args) {
        String s = "FRANCE";
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(1, 3));
        System.out.println(s.substring(2, 4));
        System.out.println(s.substring(3, 5));
        System.out.println(s.substring(4, 6));
        for (int i = 0; i < s.length() - 1; i++) {
            System.out.println(s.substring(i, i + 2));
        }
    }

}

