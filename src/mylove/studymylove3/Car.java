package mylove.studymylove3;

public class Car {
    private String color;
    private String gearType;
    public int door;


    @Override
    public String toString() {
        return "Cat [a=" + color + " " + "b=" + gearType + "]";
    }

    public Car() {
    }

    public Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

}
