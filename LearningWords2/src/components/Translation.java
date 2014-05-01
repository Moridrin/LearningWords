//<editor-fold defaultstate="collapsed" desc="Jibberish">
package components;

//</editor-fold>
/**
 * In this class you can find all properties and operations for Translation.
 * //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public class Translation {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private String mainWord;
    private String mainHint;
    private String languageWord;
    private String languageHint;
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the constructor for Translation.
     *
     * @param mainWord is the word in the main language.
     * @param mainHint is a hint that helps the tester understand the main word.
     * @param languageWord is the translation of mainWord.
     * @param languageHint is a hint that helps the tester understand the
     * language word.
     */
    public Translation(String mainWord, String mainHint, String languageWord, String languageHint) {
        this.mainWord = mainWord;
        this.mainHint = mainHint;
        this.languageWord = languageWord;
        this.languageHint = languageHint;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Class">
    //<editor-fold defaultstate="collapsed" desc="Getters">
    //<editor-fold defaultstate="collapsed" desc="getMainWord()">
    /**
     * This operation returns a string of the main word.
     *
     * @return the main word.
     */
    public String getMainWord() {
        return mainWord;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getMainHint()">
    /**
     * This operation returns a string of the main hint.
     *
     * @return the main hint.
     */
    public String getMainHint() {
        if (mainHint != null && !mainHint.equals("null")) {
            return mainHint;
        } else {
            return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageWord()">
    /**
     * This operation returns a string of the language word.
     *
     * @return the language word.
     */
    public String getLanguageWord() {
        return languageWord;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageHint()">
    /**
     * This operation returns a string of the language hint.
     *
     * @return the language hint.
     */
    public String getLanguageHint() {
        if (!languageHint.equals("null")) {
            return languageHint;
        } else {
            return null;
        }
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setters">
    //<editor-fold defaultstate="collapsed" desc="setMainWord(mainWord)">
    /**
     * This operation returns a string of the main word.
     *
     * @param mainWord
     */
    public void setMainWord(String mainWord) {
        this.mainWord = mainWord;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setMainHint(mainHint)">
    /**
     * This operation returns a string of the main hint.
     *
     * @param mainHint
     */
    public void setMainHint(String mainHint) {
        this.mainHint = mainHint;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setLanguageWord(languageWord)">
    /**
     * This operation returns a string of the language word.
     *
     * @param languageWord
     */
    public void setLanguageWord(String languageWord) {
        this.languageWord = languageWord;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setLanguageHint(languageHint)">
    /**
     * This operation returns a string of the language hint.
     *
     * @param languageHint
     */
    public void setLanguageHint(String languageHint) {
        this.languageHint = languageHint;
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Class">
    //<editor-fold defaultstate="collapsed" desc="toString()">
    @Override
    public String toString() {
        return mainWord + mainHint;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="equals(object)">
    @Override
    public boolean equals(Object object) {
        if (object instanceof Translation) {
            return this.equals((Translation) object);
        } else {
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="equals(translation)">
    public boolean equals(Translation translation) {
        return ((this.mainWord.equals(translation.mainWord) && this.languageWord.equals(translation.languageWord)));
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
}
