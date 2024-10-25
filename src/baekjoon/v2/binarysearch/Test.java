package baekjoon.v2.binarysearch;

public class Test {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 8, 10, 11, 12};
        int target = 8;
        int left = 0;
        int right = ints.length;

        while (left < right) {
            int mid = left + (right - left) / 2; // 오버 플로우 방지

            if (ints[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println(left + " " + mid + " " + right);
        }
    }
}
