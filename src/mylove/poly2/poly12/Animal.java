package mylove.poly2.poly12;

public class Animal {
    String name;

    public Animal() {

    }

    public Animal(String name) {
        super();
        this.name = name;
    }
}

class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name=" + name + '\'' +
                '}';
    }
}

class Pig extends Animal {
    public Pig() {
    }

    public Pig(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name=" + name + '\'' +
                '}';
    }
}
