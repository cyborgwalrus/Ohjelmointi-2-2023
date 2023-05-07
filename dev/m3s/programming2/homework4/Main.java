package dev.m3s.programming2.homework4;
import java.io.*;

public class Main {
    static int GUESSES = 10;

    public static void main(String[] args) {
        //Setup wordList
        WordList wordList = null;
        try {
            wordList = new WordList("words.txt");
        } catch (IOException e) {
            System.out.println("Loading wordlist failed.");
            System.exit(1);
        }

        //Setup Hangman
        Hangman hangMan = new Hangman(wordList, GUESSES);
        String hiddenWord = hangMan.word();

        //Main loop
        String outputString;
        while (hangMan.theEnd() == false && hangMan.guessesLeft() > 0) {
            outputString = "";
            outputString += "The hidden word...\n\n";
            
            //Build hidden word string
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
            //outputString complete, printing...
            System.out.print(outputString);

            //Handling user input
            char inputChar = System.console().readLine("Guess a letter: ").charAt(0);
            if(Character.isLetter(inputChar))
                hangMan.guess(inputChar);
            
        }
        //Game over
        outputString = "\n";
        if(hangMan.guessesLeft() > 0)
            outputString += "Congratulations! You won!!!\n";
        else
            outputString += "Sorry, you lost!\n";
        
        outputString += String.format("The hidden word was: \"%s\"\n", hangMan.word());
        System.out.println(outputString);

        
    }
}
