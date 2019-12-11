package trigramSeg;

public class EntryWord {
    public String word;
    public int freq;

    public EntryWord(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    public String toString() {

        return word + " : " + freq;
    }
}
