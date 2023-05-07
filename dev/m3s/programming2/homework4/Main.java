import java.io.*;
import java.util.*;

public class Main {
    static int GUESSES = 55;

    public static void main(String[] args) {
        WordList wordList = null;
        try {
            wordList = new WordList("words.txt");
        } catch (IOException e) {
            System.out.println("Loading wordlist failed.");
            System.exit(1);
        }

        Hangman hangMan = new Hangman(wordList, GUESSES);
        String hiddenWord = hangMan.word();
        boolean wasGuessCorrect;

        // TODO remove before submitting
        Random rand = new Random();
        // TODO
        String outputString = "";
        while (hangMan.theEnd() == false && hangMan.guessesLeft() > 0) {
            
            // TODO testing
            char randomChar = (char) (rand.nextInt(26) + 'a');
            // TODO testing

            wasGuessCorrect = hangMan.guess(randomChar);
            if(wasGuessCorrect == true){

            }

            outputString += "The hidden word...\n\n";
            
            String hiddenWordString = "";
            for(int i=0; i < hiddenWord.length(); i++){
                char c = hiddenWord.charAt(i);
                if(hangMan.guesses().contains(c)){
                    hiddenWordString += c + " ";
                }
                else{
                    hiddenWordString += "* ";
                }
            }
            outputString += hiddenWordString + "\n\n";

            outputString += String.format("Guesses left: %d\n", hangMan.guessesLeft());
            outputString += String.format("Guessed letters: %s\n\n", hangMan.guesses().toString());

            System.out.print(outputString);
            
        }
        outputString = "";
        if(hangMan.guessesLeft() > 0)
            outputString += "Congratulations! You won!!!\n";
        else
            outputString += "Sorry, you lost!\n";
        
        outputString += String.format("The hidden word was: \"%s\"\n", hangMan.word());
        System.out.println(outputString);
    }
}
