package mylove.poly2.poly19;

public class Product {
    int price;

    public Product() {

    }

    public Product(int price) {
        this.price = price;
    }
}

class TV extends Product {
    public TV() {
        super(100);
    }

    @Override
    public String toString() {
        return "TV";
    }
}

class Computer extends Product {
    public Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {
    public Audio() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}