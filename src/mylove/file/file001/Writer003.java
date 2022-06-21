package mylove.file.file001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        int num = 0;
        if (!file.exists()) { // 파일이 존재하지 않는다면
            pen = Files.newBufferedWriter(paths, StandardCharsets.UTF_8);
            file.createNewFile();  //파일 만들기
        } else { // 파일이 존재한다면 이어쓰기
            pen = Files.newBufferedWriter(paths, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            BufferedReader bufferedReader = Files.newBufferedReader(paths, StandardCharsets.UTF_8);
            List<String> list = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            if (!list.isEmpty()) {
                StringTokenizer stringTokenizer = new StringTokenizer(list.get(list.size() - 1));
                num = Integer.parseInt(stringTokenizer.nextToken());
            }
            bufferedReader.close();
        }
        List<MilkDtoF1> list = new ArrayList<>();
        while (true) {
            MilkDtoF1 milkDtoF1 = new MilkDtoF1();
            System.out.println("우유이름입력 > ");
            String milk = scanner.next();
            System.out.println("우유가격입력 > ");
            int money = scanner.nextInt();
            num++;
            milkDtoF1.setMno(num);
            milkDtoF1.setMname(milk);
            milkDtoF1.setMprice(money);
            System.out.println("입력이 다 끝났습니까 ? (y/n) > ");
            String s = scanner.next();
            list.add(milkDtoF1);
            if (s.equals("y")) {
                break;
            }
        }
        pen.write("=====================\n");
        pen.write("NO     NAME     PRICE\n");
        pen.write("=====================\n");
        for (MilkDtoF1 milkDtoF1 : list) {
            pen.write(milkDtoF1.getMno() + " " + milkDtoF1.getMname() + " " + milkDtoF1.getMprice());
            pen.newLine();
        }
        pen.flush();
        pen.close();
        System.out.println("파일쓰기 성공!");
        BufferedReader bufferedReader = Files.newBufferedReader(paths, StandardCharsets.UTF_8);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}

class MilkDtoF1 {
    private int mno;
    private String mname;
    private int mprice;

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getMprice() {
        return mprice;
    }

    public void setMprice(int mprice) {
        this.mprice = mprice;
    }
}
