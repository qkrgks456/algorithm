package mylove.studymylove4.extentds.extends8;

public class Main {
    public static void main(String[] args) {
        SutdaCard card1 = new SutdaCard();
        System.out.println(card1);
        SutdaCard card2 = new SutdaCard(3, false);
        System.out.println(card2);
        System.out.println("---------------------------");
        StudaDeck deck = new StudaDeck();
        System.out.println(deck);
    }
}
