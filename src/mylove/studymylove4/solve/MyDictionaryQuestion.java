package mylove.studymylove4.solve;

import java.util.Random;
import java.util.Scanner;

public class MyDictionaryQuestion {
    public void dicQuestion(MyDictionary[] words) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < words.length; i++) {
            // 0 1 2 3
            String origin = words[i].getWord();   // 기존에 모습은 있어야해서 원본 그릇을 만들어줌 0번은 텔레비전
            char[] shuffle = words[i].getWord().toCharArray(); //섞기 위한 그릇
            // t e l e v i s i o n
            for (int j = shuffle.length - 1; j > 0; j--) {
                // 9 8 7 6 5 4 3 2 1 별표 백개
                Random random = new Random();
                int num = random.nextInt(j + 1); //예를 들어, nextInt(10) 이렇게 하면 0~9까지의 랜덤한 숫자가 나옵니다.
                // nextInt(9) 이렇게 하면 0~8
                // nextInt(8) 이렇게 하면 0~7 이렇게 줄어들면서 해서 중복되지 않게 해줌
                char ch = shuffle[j];  //그릇에 담아놔야 제대로 바뀜
                shuffle[j] = shuffle[num];
                shuffle[num] = ch;
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
