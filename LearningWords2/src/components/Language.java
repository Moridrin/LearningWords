//<editor-fold defaultstate="collapsed" desc="Jibberish">
package components;

import java.util.ArrayList;
import java.util.List;
//</editor-fold>

/**
 * In this class you can find all properties and operations for Language. //CHECK
 * Commit Test
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public class Language {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private final String name;
    private final List<Translation> translations;
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the constructor for Language. The name will be set, as well as the list of translations (currently empty).
     *
     * @param language is the name of this language.
     */
    public Language(String language) {
        name = language;
        translations = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters">
    //<editor-fold defaultstate="collapsed" desc="getAll()">
    /**
     * This operation returns a list of all the translations in this language.
     *
     * @return the list of translations.
     */
    public List<Translation> getAll() {
        return translations;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getMainWords()">
    /**
     * This operation returns a list of all the main words in this language.
     *
     * @return the list of main words.
     */
    public List<String> getMainWords() {
        List<String> returner = new ArrayList<>();
        for (Translation wordInList : translations) {
            returner.add(wordInList.getMainWord());
        }
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getMainWords(word)">
    /**
     * This operation returns a list of all the main words in the language that are translations for the word given.
     *
     * @param word the word that needs to be translated.
     *
     * @return the list of words that are translations for the given word.
     */
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

    //<editor-fold defaultstate="collapsed" desc="getMainHint(mainWord)">
    /**
     * This operation returns the hint that goes with the given main word. If the translation gives null as hint this operation
     * returns a blanc string.
     *
     * @param mainWord is the word of which the hint is returned.
     *
     * @return the hint of the given main word.
     */
    public String getMainHint(String mainWord) {
        String returner = "";
        for (Translation translation : translations) {
            if (translation.getMainWord().equals(mainWord)) {
                if (translation.getMainHint() != null) {
                    returner = translation.getMainHint();
                }
            }
        }
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageWords()">
    /**
     * This operation returns all the language (foreign) words.
     *
     * @return the list of all the language words.
     */
    public List<String> getLanguageWords() {
        List<String> returner = new ArrayList<>();
        for (Translation translation : translations) {
            returner.add(translation.getLanguageWord());
        }
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageWords(word)">
    /**
     * This operation returns a list of language words that are translations of the given main word.
     *
     * @param word is the given main word.
     *
     * @return the list of all language words that are a translation of word.
     */
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

    //<editor-fold defaultstate="collapsed" desc="getLanguageHint(languageWord)">
    /**
     * This operation returns the hint of the language word.
     *
     * @param languageWord the word where the hint belongs to.
     *
     * @return the hint that corresponds with the language word.
     */
    public String getLanguageHint(String languageWord) {
        String returner = "";
        for (Translation translation : translations) {
            if (translation.getLanguageWord().equals(languageWord)) {
                returner = translation.getLanguageHint();
            }
        }
        return returner;
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setters">
    //<editor-fold defaultstate="collapsed" desc="clear()">
    /**
     * This operation clears the list of translations.
     */
    public void clear() {
        translations.clear();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addWord(mainWord, languageWord)">
    /**
     * This operation adds a translation to the word-lists. If the translation already exists, it won't be added.
     *
     * @param mainWord     is the word in the Main Language.
     * @param mainHint     is a hint that explains the Main Word.
     * @param languageWord is the word in the Foreign Language.
     * @param languageHint is a hint (like Pinyin).
     */
    public void addWord(String mainWord, String mainHint, String languageWord, String languageHint) {
        if (!this.translations.contains(new Translation(mainWord, mainHint, languageWord, languageHint))) {
            translations.add(new Translation(mainWord, mainHint, languageWord, languageHint));
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
     * This operation adds a range of words to the word-lists. If the translation already exists, it won't be added. Translations
     * need to have the same index in both lists.
     *
     * @param mainWords     is the list of words in the Main Language List.
     * @param mainHints     is the list of words to be added to the Main Hint List.
     * @param languageWords is the list of words to be added to the Foreign Language List.
     * @param languageHints is the list of words to be added to the Language Hint List.
     */
    public void addWordRange(List<String> mainWords, List<String> mainHints, List<String> languageWords, List<String> languageHints) {
        for (int i = 0; i < mainWords.size(); i++) {
            addWord(mainWords.get(i), mainHints.get(i), languageWords.get(i), languageHints.get(i));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addWordRange(translations)">
    /**
     * This operation adds a range of words to the word-lists. If the translation already exists, it won't be added. Translations
     * need to have the same index in both lists.
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
