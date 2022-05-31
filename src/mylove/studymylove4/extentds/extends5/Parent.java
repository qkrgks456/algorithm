package mylove.studymylove4.extentds.extends5;

public class Parent {
    int i, j;

    public Parent() {
        super(); // Object
    }

    public Parent(int i, int j) {
        super(); // Object
        this.i = i;
        this.j = j;
    }
}

class Child extends Parent {
    int k;

    public Child() {
        super(); // Parent
    }

    public Child(int i, int j, int k) {
        super(i, j); // Parent
        this.k = k;
    }
}