package mylove.studymylove4.extentds.extends9;

import java.util.Arrays;
import java.util.Random;

public class SutdaCard_v2 {
    int num;
    boolean isKwang;

    public SutdaCard_v2() {
        this(1, true);
    }

    public SutdaCard_v2(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public String toString() {
        return "" + num + (isKwang ? "K" : "");
    }
}

class StudaDeck_v2 {
    SutdaCard_v2[] cards;
    int CARD_NUM = 20;

    public StudaDeck_v2() {
        this.cards = new SutdaCard_v2[20];
        for (int i = 0; i < 20; i++) {
            boolean isKwang = false;
            if (i == 0 || i == 2 || i == 7) {
                isKwang = true;
            }
            if (i < 10) {
                this.cards[i] = new SutdaCard_v2((i + 1), isKwang);
            } else {
                this.cards[i] = new SutdaCard_v2((i + 1) - 10, false);
            }

        }
    }

    @Override
    public String toString() {
        return "StudaDeck{CARD_NUM=" + CARD_NUM +
                ", cards=" + Arrays.toString(cards) + "}";
    }

    public SutdaCard_v2 pick(int num) {
        return this.cards[num];
    }

    public SutdaCard_v2 pick() {
        Random random = new Random();
        int num = random.nextInt(20);
        return this.cards[num];
    }

    public void shuffle() {
        for (int i = 19; i > 0; i--) {
            Random random = new Random();
            int num = random.nextInt(i + 1);
            SutdaCard_v2 ch = this.cards[i];
            this.cards[i] = this.cards[num];
            this.cards[num] = ch;
        }
    }
}
