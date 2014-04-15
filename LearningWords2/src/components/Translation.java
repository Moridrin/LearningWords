//<editor-fold defaultstate="collapsed" desc="Jibberish">
package components;

//</editor-fold>
/**
 * In this class you can find all properties and operations for Translation. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public class Translation {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private final String mainWord;
    private final String mainHint;
    private final String languageWord;
    private final String languageHint;
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the constructor for Translation.
     *
     * @param mainWord
     * @param mainHint
     * @param languageWord
     * @param languageHint
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
    public String getMainWord() {
        return mainWord;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getMainHint()">
    public String getMainHint() {
        if (!mainHint.equals("null")) {
            return mainHint;
        } else {
            return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageWord()">
    public String getLanguageWord() {
        return languageWord;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageHint()">
    public String getLanguageHint() {
        if (!languageHint.equals("null")) {
            return languageHint;
        } else {
            return null;
        }
    }
    //</editor-fold>
    //</editor-fold>

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