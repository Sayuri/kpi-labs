package lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordsWithUniqueSymbolsFinderTest {

    @Test
    void findWordsWithUniqueSymbols() {
        WordsWithUniqueSymbolsFinder wordsWithUniqueSymbolsFinder = new WordsWithUniqueSymbolsFinder();
        String[] input = {"first", "second", "third", "fourth", "fifth"};
        String[] expResult = {"first", "second", "third", "fourth"};

        String[] actResult = wordsWithUniqueSymbolsFinder.findWordsWithUniqueSymbols(input);

        assertArrayEquals(expResult, actResult);
    }
}
