package lab1;

import java.util.ArrayList;

public class WordsWithUniqueSymbolsFinder {

    public String[] findWordsWithUniqueSymbols(String[] words) {
        ArrayList<String> wordWithUniqueSymbols = new ArrayList<>();

        for (String s : words) {
            if(allSymbolsUnique(s)){
                wordWithUniqueSymbols.add(s);
            }
        }
        return wordWithUniqueSymbols.toArray(new String[0]);
    }

    private boolean allSymbolsUnique(String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}