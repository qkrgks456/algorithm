public class Main2 {

    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        String[] strings = s.split("");
        int result = 0;
        while (true) {
            int ch1 = 1;
            int ch2 = 0;
            String ch = strings[0];
            for (int i = 1; i < strings.length; i++) {
                if (ch.equals(strings[i])) {
                    ch1++;
                    continue;
                }
                ch2++;
                if (ch1 == ch2) {
                    String s1 = String.join("", strings);
                    strings = s1.substring(i + 1).split("");
                    result++;
                    break;
                }
            }
            if (strings.length == 1) {
                if (!strings[0].isEmpty()) result++;
                break;
            }
        }
        System.out.println(result);
    }
}
