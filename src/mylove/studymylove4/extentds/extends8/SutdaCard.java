package mylove.studymylove4.extentds.extends8;

import java.util.Arrays;

public class SutdaCard {
    int num;
    boolean isKwang;

    public SutdaCard() {
        this(1, true);
    }

    public SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public String toString() {
        return "" + num + (isKwang ? "K" : "");
    }
}

class StudaDeck {
    SutdaCard[] cards;
    int CARD_NUM = 20;

    public StudaDeck() {
        this.cards = new SutdaCard[20];
        for (int i = 0; i < 20; i++) {
            boolean isKwang = false;
            if (i == 0 || i == 2 || i == 7) {
                isKwang = true;
            }
            if (i < 10) {
                this.cards[i] = new SutdaCard((i + 1), isKwang);
            } else {
                this.cards[i] = new SutdaCard((i + 1) - 10, false);
            }

        }
    }

    @Override
    public String toString() {
        return "StudaDeck{CARD_NUM=" + CARD_NUM +
                ", cards=" + Arrays.toString(cards) + "}";
    }
}
