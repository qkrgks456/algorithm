package mylove.file.file001;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class File001 {
    public static void main(String[] args) {

        SimpleDateFormat dtf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        File file = new File("D:\\file001" + "write1" + formattedDate + ".txt");
        System.out.println("파일이 존재합니까?" + file.exists());
        if (!file.exists()) {
            try {
                file.createNewFile();  //파일을 만들어주세요
            } catch (IOException e) {

                throw new RuntimeException(e);
                //   e.printStackTrace();
            }

            System.out.println("파일이 존재합니까?" + file.exists());
        }
    }
}
