package mylove.studymylove2;

public class Main10 {
    public static void main(String[] args) {
        int[] arr = {30, 80, 60, 50, 20, 100};
        System.out.println(maxArray(arr, arr.length));
    }

    private static int maxArray(int[] arr, int length) {
        if (length == 0) {
            return arr[0];
        }
        return Math.max(arr[length - 1], maxArray(arr, length - 1));
    }
}
