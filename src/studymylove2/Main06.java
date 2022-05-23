package studymylove2;

import java.util.Arrays;

public class Main06 {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(Arrays.toString(result));
    }

    public static int[] shuffle(int[] original) {
        // 랜덤에서 범위 정해주기
        // (int) Math.random() * original.length -> 0 ~ 8까지 랜덤으로 나타남
        for (int i = 0; i < original.length; i++) {
            int n1 = (int) (Math.random() * original.length);
            int n2 = (int) (Math.random() * original.length);
            // 두개 랜덤한 자리 교체
            int num = original[n1];
            original[n1] = original[n2];
            original[n2] = num;
        }
        return original;
    }
}
