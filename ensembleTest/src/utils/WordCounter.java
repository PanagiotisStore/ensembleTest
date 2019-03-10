package utils;

import model.WordCountModel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

public class WordCounter {

    public Map<String,Integer> wordsCounter(List<String> words) {
        Map<String, Integer> result = new ConcurrentHashMap<>();
        int i = 0;
        for (String word: words) {
            i++;
            if(result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                boolean addToHashMap = true;
                boolean removed = true;
                for (String resultWord: result.keySet()) {

                    if(resultWord.indexOf(word) == -1 && word.length() > resultWord.length())  {
                        result.remove(resultWord);
                        result.put(word,1);
                        addToHashMap =false;
                    } else if ((word.indexOf(resultWord) == -1 && word.length() < resultWord.length()) )  {
                        result.remove(word);
                        if (i == words.size()) {
                            removed = false;
                        }
                        continue;
                    }
                }
                if(addToHashMap && removed) {
                    result.put(word, 1);
                }
            }
        }
        return  result;
    }

    public List<WordCountModel> sortHashMap(Map<String, Integer> hashMapToBeSorted) {
        List<WordCountModel> wordCountModels = new LinkedList<>();
        for(String values: hashMapToBeSorted.keySet()) {
            wordCountModels.add(new WordCountModel(capitalize(values), hashMapToBeSorted.get(values)));
        }

        return wordCountModels.stream().sorted(Comparator.comparing(WordCountModel::getCounter).reversed()).collect(Collectors.toList());
    }
}

