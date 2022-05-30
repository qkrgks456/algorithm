package mylove.studymylove4.apple;

public class Apple_Print {
    public void show(Apple apple) {
        System.out.println("::::: APPLE ORDER");
        System.out.println("NAME " + apple.getName());
        System.out.println("NUM " + apple.getNum());
        System.out.println("PRICE " + apple.getPrice());
    }

    public void show(Apple[] apple) {
        for (int i = 0; i < apple.length; i++) {
            System.out.println("::::: APPLE ORDER");
            System.out.println("NAME " + apple[i].getName());
            System.out.println("NUM " + apple[i].getNum());
            System.out.println("PRICE " + apple[i].getPrice());
        }
    }
}
