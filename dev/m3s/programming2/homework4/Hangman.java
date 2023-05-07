import java.io.IOException;
import java.util.*;

public class Hangman {
    private String word;
    private Set<Character> wordUniqueCharacters;
    private int guessesRemaining;
    private Set<Character> guessedCharacters;

    public Hangman(WordList wordList, int numberOfGuesses) {
        word = wordList.getRandomWord();
        wordUniqueCharacters = new HashSet<Character>();
        for (Character c : word.toCharArray()) {
            wordUniqueCharacters.add(c);
        }

        guessesRemaining = numberOfGuesses;
        guessedCharacters = new HashSet<Character>();
    }

    public boolean guess(Character c) {
        c = Character.toLowerCase(c);
        if (guessedCharacters.contains(c) == true)
            return false;

        guessedCharacters.add(c);

        for (Character _c : word.toCharArray()) {
            if (c == _c)
                return true;
        }
        // word didn't contain c
        guessesRemaining--;
        return false;
    }

    public List<Character> guesses() {
        return new ArrayList<>(guessedCharacters);
    }

    public Set<Character> getWordUniqueCharacters() {
        return wordUniqueCharacters;
    }

    public int guessesLeft() {
        return guessesRemaining;
    }

    public String word() {
        return word;
    }

    public boolean theEnd() {
        if (guessedCharacters.containsAll(wordUniqueCharacters))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println("Reading wordlist...");
        WordList wordList = null;
        Hangman hangMan = null;
        try {
            wordList = new WordList("words.txt");

        } catch (IOException e) {
            System.out.println("Reading wordlist failed.");
        }
        System.out.println("Reading wordlist complete.");
        System.out.println("Setting up Hangman...");
        hangMan = new Hangman(wordList, 10);
        System.out.println("Setting up Hangman complete.");

        System.out.println(String.format("Selected word: %s   %s", hangMan.word(), hangMan.getWordUniqueCharacters()));

        Random rand = new Random();
        Character randomChar;
        while (true) {
            randomChar = (char) (rand.nextInt(26) + 'a');
            hangMan.guess(randomChar);
            System.out.println(String.format("Guessed: %c   Guesses: %s",
                    randomChar, hangMan.guesses().toString()));
            if (hangMan.theEnd()) {
                System.out.println("You Won.");
                break;
            }
            if (hangMan.guessesRemaining == 0) {
                System.out.println("Game over. You ran out of guesses.");
                break;
            }
        }

    }
}
