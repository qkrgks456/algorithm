package programmers.problem.level1_4;

public class Solution3 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] strings1 = new String[n][n];
        for (int i = 0; i < n; i++) {
            String toBinaryString = Integer.toBinaryString(arr1[i]);
            String binaryString = Integer.toBinaryString(arr2[i]);
            if (toBinaryString.length() < n) {
                while (toBinaryString.length() != n) {
                    toBinaryString = "0" + toBinaryString;
                }
            }
            if (binaryString.length() < n) {
                while (binaryString.length() != n) {
                    binaryString = "0" + binaryString;
                }
            }
            String[] strings = toBinaryString.split("");
            String[] strings2 = binaryString.split("");
            for (int j = 0; j < n; j++) {
                if (strings[j].equals("1")) {
                    strings1[i][j] = "#";
                }
                if (strings2[j].equals("1")) {
                    strings1[i][j] = "#";
                }
            }
        }
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                String s = strings1[i][j] == null ? " " : strings1[i][j];
                stringBuilder.append(s);
            }
            answer[i] = stringBuilder.toString();
        }
        return answer;
    }

    public String decimalToBinary(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        // Size of the integer is 32 bits
        for (int x = number - 1; x >= 0; x--) {
            int k = number >> x;
            if ((k & 1) > 0) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }
}
