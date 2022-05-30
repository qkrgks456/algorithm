package mylove.studymylove4.solve;

public class MyDictionaryShow {
    public void show(MyDictionary[] words) {
        System.out.println("=============================");
        System.out.println(":::::::::::: DICTIONARY!");
        System.out.println("=============================");
        System.out.println("NO     ANSWER     WORD");
        for (int i = 0; i < words.length; i++) {
            System.out.println("--------------------------------");
            System.out.println(words[i].getDno() + "    " + words[i].getUserAnswer() + "        " + words[i].getWord());
        }
        System.out.println("정답갯수는 : " + MyDictionary.trueAnswer);
    }
}
