package mylove.file.file001;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Writer003 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File folder = new File("/Users/hansol/Develop/file"); // 폴더 만들 경로 지정
        System.out.println("폴더가 존재하나요? " + folder.exists());
        if (!folder.exists()) { // 폴더가 존재하지않는다면
            folder.mkdir(); // 폴더 만들기
            System.out.println("폴더생성");
        }
        System.out.println();
        Path paths = Paths.get("/Users/hansol/Develop/file/write2.txt"); // Paths 객체에 파일 경로 지정
        File file = new File(paths.toString()); // 파일 경로 지정
        BufferedWriter pen;
        if (!file.exists()) { // 파일이 존재하지 않는다면
            file.createNewFile();  //파일 만들기
            pen = Files.newBufferedWriter(paths, StandardCharsets.UTF_8);
        } else { // 파일이 존재한다면 이어쓰기
            pen = Files.newBufferedWriter(paths, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            pen.newLine();
        }
        int num = 0;
        while (true) {
            System.out.println("우유이름입력 > ");
            String milk = scanner.next();
            System.out.println("우유가격입력 > ");
            String money = scanner.next();
            num++;
            pen.write(num + "   ");
            pen.write(milk + "   ");
            pen.write(money);
            System.out.println("입력이 다 끝났습니까 ? (y/n) > ");
            String s = scanner.next();
            if (s.equals("y")) {
                break;
            }
            pen.newLine();
        }
        pen.flush();
        pen.close();
        System.out.println("파일쓰기 성공!");
    }
}
