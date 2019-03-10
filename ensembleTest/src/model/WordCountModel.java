package model;

public class WordCountModel {
    private String word;
    private int counter;

    public WordCountModel(String word, int counter) {
        this.word = word;
        this.counter = counter;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "WordCountModel{" +
                "word='" + word + '\'' +
                ", counter=" + counter +
                '}';
    }
}
