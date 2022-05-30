package mylove.studymylove4.solve;

public class MyDictionary {
    static int dno_count = 0;
    static int trueAnswer = 0;
    private int dno;
    private String word;
    private char userAnswer;

    public MyDictionary(String word) {
        this.word = word;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public char getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(char userAnswer) {
        this.userAnswer = userAnswer;
    }
}
