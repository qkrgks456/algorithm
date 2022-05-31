package mylove.studymylove4.extentds.extends9;

public class Main {
    public static void main(String[] args) {
        StudaDeck_v2 deck = new StudaDeck_v2();
        System.out.println(deck);
        System.out.println(deck.pick(0));
        System.out.println(deck.pick());

        deck.shuffle();
        System.out.println(deck);
        System.out.println(deck.pick(0));
    }
}
