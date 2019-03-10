package test;


import model.WordCountModel;
import org.junit.Assert;
import org.junit.Test;
import utils.WordCounter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordCounterTest {

    WordCounter wordCounterRepository = new WordCounter();

    @Test
    public void wordCountryRepositoryTest() {
        String[] words = {"A", "mate" , "material", "may","maybe","right","maybe"};
        Map<String, Integer> counterModel = wordCounterRepository.wordsCounter(Arrays.asList(words));
        Assert.assertEquals(3, counterModel.size() );
    }

    @Test
    public void wordCountRepTestMore() {
        String[] words = {"material", "may","maybe","right","maybe","A", "material", "may", "may"};
        Map<String, Integer> counterModel = wordCounterRepository.wordsCounter(Arrays.asList(words));
        List<WordCountModel> list = wordCounterRepository.sortHashMap(counterModel);
        Assert.assertEquals(new WordCountModel("Material", 2).toString(), list.get(0).toString());
        Assert.assertEquals(new WordCountModel("Maybe", 2).toString(), list.get(1).toString());
        Assert.assertEquals(new WordCountModel("Right", 1).toString(), list.get(2).toString());
    }
}
