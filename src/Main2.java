public class Main2 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] check = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                check[i][j] = arr[3 - 1 - j][i];
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
    }
}
