import java.io.*;
import java.util.*;

public class WordList {
    private List<String> wordList = new ArrayList<String>();
    private Random rand = new Random();

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

    public String getRandomWord(){
        return wordList.get(rand.nextInt(wordList.size()));
    }

    public int size() {
        return wordList.size();
    }

    public static void main(String[] args) {
        try {
            WordList wordList = new WordList("words.txt");
            System.out.println(String.format("Words loaded: %d", wordList.size()));
            System.out.println(String.format("Random word: %s", wordList.getRandomWord()));
        } catch (IOException e) {
            System.out.println("File couldn't be opened.");
        }

    }
}
