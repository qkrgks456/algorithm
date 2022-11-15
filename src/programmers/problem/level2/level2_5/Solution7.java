package programmers.problem.level2.level2_5;

import java.util.*;

public class Solution7 {
    public String[] solution(String[] files) {
        List<FileData> list = new ArrayList<>();
        for (String file : files) {
            int check = 0;
            int check1 = file.length();
            // 숫자 시작 지점
            for (int i = 0; i < file.length(); i++) {
                if (Character.isDigit(file.charAt(i))) {
                    check = i;
                    break;
                }
            }
            // 숫자 끝나는 지점
            for (int i = check; i < file.length(); i++) {
                if (!Character.isDigit(file.charAt(i))) {
                    check1 = i;
                    break;
                }
            }
            FileData fileData = new FileData();
            fileData.head = file.substring(0, check);
            while (check1 - check > 5) {
                check1--;
            }
            // 아 여기가 문제인데 어떻게 바꾸지 ?
            fileData.number = file.substring(check, check1);
            fileData.tail = file.substring(check1);
            list.add(fileData);
        }
        list.sort(new FileData());
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            FileData fileData = list.get(i);
            answer[i] = fileData.sumString();
        }
        return answer;
    }
}

class FileData implements Comparator<FileData> {
    public String head;
    public String number;
    public String tail;

    public String sumString() {
        return head + number + tail;
    }

    @Override
    public int compare(FileData o1, FileData o2) {
        if (o1.head.toUpperCase(Locale.ROOT)
                .compareTo(o2.head.toUpperCase(Locale.ROOT)) == 0) {
            return Integer.compare(Integer.parseInt(o1.number), Integer.parseInt(o2.number));
        }
        return o1.head.toUpperCase(Locale.ROOT)
                .compareTo(o2.head.toUpperCase(Locale.ROOT));
    }

}
