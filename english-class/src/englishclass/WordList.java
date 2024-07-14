package englishclass;

import java.util.ArrayList;
import java.util.List;

public class WordList {
    private List<String> words;

    public WordList() {
        this.words = new ArrayList<>();
    }
    public void addWord(String word) {
        words.add(word);
    }
    public void removeWord(String word) {
        words.remove(word);
    }
    public List<String> getWords() {
        return words;
    }
    @Override
    public String toString() {
        return String.join(", ", words);
    }
}
