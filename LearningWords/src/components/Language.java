//<editor-fold defaultstate="collapsed" desc="Jibberish">
package components;

//</editor-fold>
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * In this class you can find all properties and operations for Language. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public class Language {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private final String name;
    private final List<Translation> translations;
    Random random = new Random();
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the constructor for Language.
     *
     * @param language
     */
    public Language(String language) {
        name = language;
        translations = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters">
    //<editor-fold defaultstate="collapsed" desc="getMainWords()">
    public String getRandomMain(List<String> askedWords) {
        String returner = null;
        List<String> toBeAsked = getMainWords();
        toBeAsked.removeAll(askedWords);
        int randomI = random.nextInt(toBeAsked.size());
        returner = toBeAsked.get(randomI);
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getRandomLanguage()">
    public String getRandomLanguage(List<String> askedWords) {
        String returner = null;
        List<String> toBeAsked = getLanguageWords();
        toBeAsked.removeAll(askedWords);
        int randomI = random.nextInt(toBeAsked.size());
        returner = toBeAsked.get(randomI);
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getObservable()">
    public ObservableList<Translation> getObservable() {
        return FXCollections.observableArrayList(translations);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getMainWords()">
    public List<String> getMainWords() {
        List<String> returner = new ArrayList<>();
        for (Translation wordInList : translations) {
            returner.add(wordInList.getMainWord());
        }
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getMainWords(word)">
    public List<String> getMainWords(String word) {
        List<String> returner = new ArrayList<>();
        for (Translation wordInList : translations) {
            if (wordInList.getLanguageWord().equals(word)) {
                returner.add(wordInList.getMainWord());
            }
        }
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageWords()">
    public List<String> getLanguageWords() {
        List<String> returner = new ArrayList<>();
        for (Translation translation : translations) {
            returner.add(translation.getLanguageWord());
        }
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageWords(word)">
    public List<String> getLanguageWords(String word) {
        List<String> returner = new ArrayList<>();
        for (Translation translation : translations) {
            if (translation.getMainWord().equals(word)) {
                returner.add(translation.getLanguageWord());
            }
        }
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getHint(languageWord)">
    public String getHint(String languageWord) {
        String returner = "";
        for (Translation translation : translations) {
            if (translation.getLanguageWord().equals(languageWord)) {
                returner = translation.getHintWord();
            }
        }
        return returner;
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setters">
    //<editor-fold defaultstate="collapsed" desc="clear()">
    public void clear() {
        translations.clear();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addWord(mainWord, languageWord)">
    /**
     * This operation adds a translation to the word-lists. If the translation already exists, it won't be added.
     *
     * @param mainWord     is the word in the Main Language.
     * @param languageWord is the word in the Foreign Language.
     * @param languageHint is a hint (like Pinyin).
     */
    public void addWord(String mainWord, String languageWord, String languageHint) {
        if (!this.translations.contains(new Translation(mainWord, languageWord, languageHint))) {
            translations.add(new Translation(mainWord, languageWord, languageHint));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addWord(translation)">
    /**
     * This operation adds a translation to the word-lists. If the translation already exists, it won't be added.
     *
     * @param translation is the Translation to be added to the word-list.
     */
    public void addWord(Translation translation) {
        if (!this.translations.contains(translation)) {
            translations.add(translation);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addWordRange(mainWords, languageWords)">
    /**
     * This operation adds a range of words to the word-lists. If the translation already exists, it won't be added.
     * Translations need to have the same index in both lists.
     *
     * @param mainWords     is the list of words in the Main Language List.
     * @param languageWords is the list of words to be added to the Foreign Language List.
     * @param languageHints is the list of words to be added to the Hint List.
     */
    public void addWordRange(List<String> mainWords, List<String> languageWords, List<String> languageHints) {
        for (int i = 0; i < mainWords.size(); i++) {
            addWord(mainWords.get(i), languageWords.get(i), languageHints.get(i));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addWordRange(translations)">
    /**
     * This operation adds a range of words to the word-lists. If the translation already exists, it won't be added.
     * Translations need to have the same index in both lists.
     *
     * @param translations is the list of translations to be added.
     */
    public void addWordRange(List<Translation> translations) {
        for (Translation translation : translations) {
            addWord(translation);
        }
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Class">
    //<editor-fold defaultstate="collapsed" desc="toString()">
    @Override
    public String toString() {
        return name;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="equals(object)">
    @Override
    public boolean equals(Object object) {
        if (object instanceof Language) {
            return this.equals((Language) object);
        } else {
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="equals(language)">
    public boolean equals(Language language) {
        return (this.translations.equals(language.translations) && this.name.equals(language.name));
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
}
