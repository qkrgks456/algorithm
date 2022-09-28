package programmers.problem.level1_4;

public class Solution3 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] strings1 = new String[n][n];
        for (int i = 0; i < n; i++) {
            String toBinaryString = Integer.toBinaryString(arr1[i]);
            String binaryString = Integer.toBinaryString(arr2[i]);
            System.out.println(toBinaryString);
            System.out.println(binaryString);
            /*String[] strings = toBinaryString.split("");
            String[] strings2 = binaryString.split("");
            for (int j = 0; j < n; j++) {
                if (strings[j].equals("1")) {
                    strings1[i][j] = "#";
                }
                if (strings2[j].equals("1")) {
                    strings1[i][j] = "#";
                }
            }*/
        }
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(strings1[i][j]);
            }
            System.out.println();
        }*/

        String[] answer = {};
        return answer;
    }

    public String DecimalToBinary(int number) {
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
