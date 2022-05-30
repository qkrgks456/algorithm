package mylove.studymylove4;

import mylove.studymylove4.inter.Score_Process;

public class Class47 {
    public static void main(String[] args) {
        // 저장할공간
        Score_ver2 iron = new Score_ver2("아이언맨", 100, 100, 99);
        Score_Process process1 = new Score_Process();
        process1.show(iron);
    }
}
