package mylove.studymylove4.solve;

import java.util.Random;
import java.util.Scanner;

public class MyDictionaryQuestion {
    public void dicQuestion(MyDictionary[] words) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < words.length; i++) {
            String origin = words[i].getWord();
            char[] shuffle = words[i].getWord().toCharArray();
            for (int j = shuffle.length - 1; j > 0; j--) {
                Random random = new Random();
                int num = random.nextInt(j + 1);
                char check = shuffle[i];
                shuffle[i] = shuffle[j];
                shuffle[j] = check;
            }
            String shuffleWord = String.valueOf(shuffle);
            System.out.print(shuffleWord + "의 정답을 입력하세요 > ");
            String s = scanner.next();

            words[i].setDno(++MyDictionary.dno_count);
            if (s.equals(origin)) {
                MyDictionary.trueAnswer++;
                words[i].setUserAnswer('O');
                System.out.println("맞았습니다.");
            } else {
                words[i].setUserAnswer('X');
                System.out.println("틀렸습니다.");
            }
        }

    }
}
