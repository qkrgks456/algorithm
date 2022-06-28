package mylove2.test;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/***
 * @author CAT~sally (4WK) PART 클래스의 활용
//[SELFTEST031]  file reader + writer
 * 1. C:\\file\\에 금일 파일만들기   금일날짜.txt
 * 2. 금일날짜.txt  APPLE, BANANA, COCONUT 입력하기
 * 3. 금일날짜.txt 읽어와서 콘솔창에 띄우기
 ***/
public class PART001_SelfTest006_31 {
    public static void main(String[] args) throws Exception {
        // 경로만들기
        File folder = new File("/Users/hansol/Develop/file");
        if (!folder.exists()) {
            folder.mkdir();
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        // 포맷 적용
        String now = localDateTime.format(formatter);
        // 파일 만들기
        String fileName = now + ".txt";
        String path = "/Users/hansol/Develop/file/" + fileName;
        File file = new File(path);
        file.createNewFile();
        // 파일 쓰기
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        bufferedWriter.write("APPLE\n");
        bufferedWriter.write("BANANA\n");
        bufferedWriter.write("COCONUT\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        // 파일 읽기
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
    }
}
