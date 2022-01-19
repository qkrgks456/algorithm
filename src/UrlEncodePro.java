import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlEncodePro {
    public static void main(String[] args) throws Exception {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferedReader.readLine();
            if (s.equals("0")) {
                break;
            }
            String s1 = URLEncoder.encode(s, StandardCharsets.UTF_8);
            System.out.println(s1);
            // String result = s1.replaceAll("%3A", "\\:").replaceAll("%2F", "\\/");
        }
    }
}
