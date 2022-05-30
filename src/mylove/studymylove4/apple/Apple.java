package mylove.studymylove4.apple;

public class Apple {
    private String name;
    private int num;
    private int price;
    private String order;


    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", order='" + order + '\'' +
                '}';
    }

    public Apple() {
    }

    public Apple(String name, int num, int price, String order) {
        this.name = name;
        this.num = num;
        this.price = price;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
