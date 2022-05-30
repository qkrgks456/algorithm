package mylove.studymylove4;

import java.util.Arrays;
import java.util.Random;

public class Main05 {
    public static void main(String[] args) {
        int[] ints = {1, 5, 3, 0, 5, 7};
        // 0 1 2 3 4 5
        for (int j = ints.length-1; j > 0; j--) {
            Random random = new Random();
            int num = random.nextInt(j + 1);
            int num2 = ints[j];
            ints[j] = ints[num];
            ints[num] = num2;
        }

        // 랜덤 뽑기
        // Random random = new Random();
        //  int num = random.nextInt(?);

        System.out.println(Arrays.toString(ints));
    }
}
