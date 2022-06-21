package mylove.file.file001;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File folder = new File("/Users/hansol/Develop/file"); // 폴더 만들 경로 지정
        System.out.println("폴더가 존재하나요? " + folder.exists());
        if (!folder.exists()) { // 폴더가 존재하지않는다면
            folder.mkdir(); // 폴더 만들기
            System.out.println("폴더생성");
        }
        System.out.println();
        Path paths = Paths.get("/Users/hansol/Develop/file/write1.txt"); // Paths 객체에 파일 경로 지정
        File file001 = new File(paths.toString()); // 파일 경로 지정
        System.out.println("우유이름입력 > ");
        String milk = scanner.next();
        System.out.println("우유가격입력 > ");
        String money = scanner.next();
        BufferedWriter pen;
        if (!file001.exists()) { // 파일이 존재하지 않는다면
            file001.createNewFile();  //파일 만들기
            pen = Files.newBufferedWriter(paths, StandardCharsets.UTF_8);
        } else { // 파일이 존재한다면 이어쓰기
            pen = Files.newBufferedWriter(paths, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            pen.newLine();
        }
        pen.write(milk + "\n");
        pen.write(money);
        pen.flush();
        pen.close();
        System.out.println("글쓰기 완료");
    }
}
