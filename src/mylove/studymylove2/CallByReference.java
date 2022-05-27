package mylove.studymylove2;

public class CallByReference {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("name = " + person.name + " age = " + person.age);
        method1(person);
        System.out.println("name = " + person.name + " age = " + person.age);
    }

    public static void method1(Person person) {
        person.name = "정미";
        person.age = 26;
        System.out.println("name = " + person.name + " age = " + person.age);
    }
}

class Person {
    String name = "한솔";
    int age = 28;
}