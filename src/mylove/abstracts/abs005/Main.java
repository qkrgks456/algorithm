package mylove.abstracts.abs005;


public class Main {
    public static void main(String[] args) {
        Shape_ex[] arr = {new Circle_ex(5, 0), new Rectangle_ex(3, 4), new Circle_ex(1)};
        System.out.println("면적의 합 " + sumArea(arr));
    }

    private static double sumArea(Shape_ex[] arr) {
        double sum = 0.0;
        for (Shape_ex shape_ex : arr) {
            sum += shape_ex.calcArea();
        }
        return sum;
    }
}
