//<editor-fold defaultstate="collapsed" desc="Jibberish">
package components;

//</editor-fold>

import javafx.beans.property.SimpleStringProperty;

/**
 * In this class you can find all properties and operations for Translation. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public class Translation {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private final SimpleStringProperty mainWord;
    private final SimpleStringProperty languageWord;
    private final SimpleStringProperty hintWord;
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the constructor for Translation.
     *
     * @param mainWord
     * @param languageWord
     * @param languageHint
     */
    public Translation(String mainWord, String languageWord, String languageHint) {
        this.mainWord = new SimpleStringProperty(mainWord);
        this.languageWord = new SimpleStringProperty(languageWord);
        this.hintWord = new SimpleStringProperty(languageHint);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Class">
    //<editor-fold defaultstate="collapsed" desc="Getters">
    //<editor-fold defaultstate="collapsed" desc="getMainWord()">
    public String getMainWord() {
        return mainWord.get();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageWord()">
    public String getLanguageWord() {
        return languageWord.get();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getLanguageWord()">
    public String getHintWord() {
        return hintWord.get();
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toString()">
    @Override
    public String toString() {
        return mainWord.get();
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
