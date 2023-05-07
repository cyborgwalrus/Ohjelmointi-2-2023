import java.io.*;
import java.util.*;

public class WordList {
    private List<String> wordList = new ArrayList<String>();
    private Random rand = new Random();

    public WordList() {
    };

    public WordList(String WordsFile) throws IOException {

        BufferedReader buffer = new BufferedReader(new FileReader(WordsFile));

        String line = buffer.readLine();
        while (line != null) {
            wordList.add(line);
            line = buffer.readLine();
        }
        buffer.close();
    }

    public List<String> giveWords() {
        return wordList;
    }

    public WordList theWordsOfLength(int length) {
        WordList newWordList = new WordList();
        for (String word : wordList) {
            if (word.length() == length)
                newWordList.add(word);
        }
        return newWordList;
    }

    // Optional methods
    public String getRandomWord() {
        return wordList.get(rand.nextInt(wordList.size()));
    }

    public int size() {
        return wordList.size();
    }

    public void add(String word) {
        wordList.add(word);
    }

    public void addAll(List<String> wordList) {
        for (String word : wordList) {
            wordList.add(word);
        }
    }

    public static void main(String[] args) {
        WordList wordList = null;
        try {
            wordList = new WordList("words.txt");
            System.out.println(String.format("Words loaded: %d", wordList.size()));
            System.out.println(String.format("Random word: %s", wordList.getRandomWord()));
        } catch (IOException e) {
            System.out.println("File couldn't be opened.");
        }
        int wordLength = 5;
        System.out.println(String.format("Creating new wordlist based on word length: %d", wordLength));
        WordList newWordList = wordList.theWordsOfLength(wordLength);
        System.out.println(String.format("Words loaded: %d", newWordList.size()));
        System.out.println(String.format("Random word: %s", newWordList.getRandomWord()));
    }
}
