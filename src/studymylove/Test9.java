package studymylove;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test9 {
    public static void main(String[] args) {
        System.out.println(setSHA256("ukids123!@#"));
    }
    public static String setSHA256(String str) {
        String SHA;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte byteData : bytes) {
                sb.append(String.format("%02x", byteData));
            }
            SHA = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            SHA = null;
        }
        return SHA;
    }
}
