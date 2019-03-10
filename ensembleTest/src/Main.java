import model.WordCountModel;
import utils.WordCounter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            WordCounter wordCounter = new WordCounter();
            FileReader fileReader = new FileReader("example.txt");
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();
            String[] lineWords;
            List<String> words = new ArrayList<>();

            while (line != null) {
                lineWords = line.split(" ");
                for (String lineword : lineWords) {
                    words.add(lineword.replaceAll("[^a-zA-Z ]", ""));
                }

                line = br.readLine();
            }

            Map<String, Integer> counterModel = wordCounter.wordsCounter(words);
            List<WordCountModel> countModels = wordCounter.sortHashMap(counterModel);
            for(WordCountModel model : countModels) {
                System.out.println(model.toString());
            }

            br.close();

        } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
