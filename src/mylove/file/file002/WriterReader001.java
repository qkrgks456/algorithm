package mylove.file.file002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class WriterReader001 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        StringBuilder b = new StringBuilder();

        String fo = "/Users/hansol/Develop/file";
        String fi = "/write2.txt";

        File folder = new File(fo);
        File file = new File(fo + fi);

        Path path = Paths.get(fo + fi);

        try {
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("폴더생성완료!");
            }
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("파일생성완료!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(b.toString());
        }

        ArrayList<MilkDtoF1> list = new ArrayList<>();
        int num = 0;
        // 여기서 마지막 줄 읽어서 값 가져오기
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            List<String> checkList = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                checkList.add(line);
            }
            if (!checkList.isEmpty()) {
                StringTokenizer stringTokenizer = new StringTokenizer(checkList.get(checkList.size() - 1));
                num = Integer.parseInt(stringTokenizer.nextToken());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (; ; ) {
            System.out.print("□ 우유의 이름을 입력해주세요 > ");
            String name = s.next();
            System.out.print("□ 우유의 가격을 입력해주세요 > ");
            int price = s.nextInt();
            list.add(new MilkDtoF1(++num, name, price));

            System.out.print("입력을 종료하시겠습니까?(y/n) > ");
            String a = s.next();
            System.out.println();
            System.out.println();
            if ("y".equals(a)) {
                break;
            }
        }


        Iterator<?> iter = list.iterator();
        try {
            BufferedWriter pen = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            pen.write("\n\n======================\n" + "NO\tNAME\tPRICE\n" + "======================\n");
            while (iter.hasNext()) {
                MilkDtoF1 m = (MilkDtoF1) iter.next();
                pen.write(m.getNo() + "\t" + m.getName() + "\t" + m.getPrice());
                pen.newLine();
            }
            pen.close();

            System.out.println("파일작성 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader r = null;
        try {
            r = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = "";

            while ((line = r.readLine()) != null) {
                b.append(line + "\n");
            }
            r.close();
            System.out.println(b.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MilkDtoF1 {
    static int c = 0;
    private int mno;
    private String mname;
    private int mprice;

    public MilkDtoF1() {
        super();
    }

    public MilkDtoF1(int no, String name, int price) {
        super();
        this.mno = no;
        this.mname = name;
        this.mprice = price;
    }
    // 여기서 하지마세여 객체 마다 c가 값이 달라져서 공통으로 못 써요
    /*public MilkDtoF1(String name, int price) {
        this.mno = ++c;
        this.mname = name;
        this.mprice = price;
    }*/

    public int getNo() {
        return mno;
    }

    public void setNo(int no) {
        this.mno = no;
    }

    public String getName() {
        return mname;
    }

    public void setName(String name) {
        this.mname = name;
    }

    public int getPrice() {
        return mprice;
    }

    public void setPrice(int price) {
        this.mprice = price;
    }
}

