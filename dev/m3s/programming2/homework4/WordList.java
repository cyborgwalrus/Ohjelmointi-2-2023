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

    public WordList theWordsWithCharacters(String inputString) {
        int lettersInInputString;
        lettersInInputString = inputString.replace("_", "").length();

        WordList wordListWithSameLength = this.theWordsOfLength(inputString.length());
        WordList outputWordList = new WordList();
        int MatchingLettersInWord;
        for (String word : wordListWithSameLength.giveWords()) {
            MatchingLettersInWord = 0;

            for (int i = 0; i < inputString.length(); i++) {
                if (inputString.charAt(i) == word.charAt(i))
                    MatchingLettersInWord++;
            }

            if (MatchingLettersInWord == lettersInInputString)
                outputWordList.add(word);
        }
        return outputWordList;
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

    public void remove(String word) {
        wordList.remove(word);
    }

    public static void main(String[] args) {
        // Testing wordList creation
        WordList wordList = null;
        System.out.println("Creating wordlist:");

        try {
            wordList = new WordList("words.txt");
            System.out.println(String.format("Words loaded: %d", wordList.size()));
            System.out.println(String.format("Random word: %s\n", wordList.getRandomWord()));
        } catch (IOException e) {
            System.out.println("File couldn't be opened.");
        }

        // Testing theWordsOfLength
        int wordLength = 5;
        System.out.println(String.format("Creating new wordlist based on word length: %d", wordLength));
        WordList newWordList = wordList.theWordsOfLength(wordLength);
        System.out.println(String.format("Words loaded: %d", newWordList.size()));
        System.out.println(String.format("Random word: %s\n", newWordList.getRandomWord()));

        // Testing TheWordsWithCharacters
        String letters = "_a_e_";
        System.out.println(String.format("Creating new wordlist based on letters : %s", letters));
        newWordList = wordList.theWordsWithCharacters(letters);
        System.out.println(String.format("Words loaded: %d", newWordList.size()));
        System.out.println(String.format("Random word: %s\n", newWordList.getRandomWord()));
    }
}
