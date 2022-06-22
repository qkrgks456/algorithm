package mylove.thread.thread005;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Thread005 {
    public static void main(String[] args) {
        while (true) {
            LocalTime now = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formatedNow = now.format(formatter);
            System.out.println(formatedNow);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
