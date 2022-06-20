package mylove.poly2.poly18;

public class Main18 {
    public static void main(String[] args) {
        Score_ver18[] std = new Score_ver18[]{
                new Score_ver18("아이언맨", 100, 100, 100),
                new Score_ver18("헐크", 90, 60, 80),
                new Score_ver18("블랙팬서", 20,60, 90)
        };
        Process18[] datas = new Process18[]{
                new Total18(), new Aver18(), new Pass18(), new Jang18(), new Star18()
        };
        Process18 process = new Process18(datas);
        process.run(std);

        Show18 print = new Show18();
        print.show(std);
    }
}
