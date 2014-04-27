//<editor-fold defaultstate="collapsed" desc="Jibberish">
package connections;

import connections.enums.LastUsed;
import components.Language;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
//</editor-fold>

/**
 * In this class you can find all operations to read and write to a Database File.
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public abstract class DatabaseFile {

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="load(language)">
    /**
     * This operation will open a file chooser, in which the user can select a file to be laded. This file will be read
     * and stored in the given language component.
     *
     * @param language is the component where the translations as read in the file will be stored.
     * @param parent   is the component that calls this function and is needed to show the file chooser.
     */
    public static void load(Language language, Component parent) {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                stringToLanguage(sb.toString(), language);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DatabaseFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DatabaseFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Nothing to do (window closed)
        }
        LastUsed.setLastUsed(LastUsed.File);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="save(language)">
    public static void save(Language language) {
        LastUsed.setLastUsed(LastUsed.File);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="save(oldValue, newValue, column)">
    public static void save(String oldValue, String newValue, int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="stringToLanguage">
    /**
     * This operation splits and converts the string as read in the file to translations and saves those in the language
     * component.
     *
     * @param string   is the string as read in the file.
     * @param language is the component in which the translations will be stored.
     */
    private static void stringToLanguage(String string, Language language) {
        String[] entries = string.split("\n");
        for (String entry : entries) {
            String[] words = entry.split("\t");
            String languageWord = words[0];
            String languageHint = words[1];
            String mainWord = words[2];
            String mainHint = null;
            if (mainWord.contains("(")) {
                mainHint = mainWord.split("\\(")[1];
                mainHint = mainHint.replaceAll("\\)", "");
                mainWord = mainWord.split("\\(")[0];
            }
            if (mainWord.contains("/")) {
                addMultiple(language, mainWord.split("/"), mainHint, languageWord, languageHint);
            } else if (mainWord.contains(";")) {
                addMultiple(language, mainWord.split(";"), mainHint, languageWord, languageHint);
            } else if (mainWord.contains(",")) {
                addMultiple(language, mainWord.split(","), mainHint, languageWord, languageHint);
            } else {
                if (mainWord.charAt(0) == ' ') {
                    mainWord = mainWord.substring(1);
                }
                language.addWord(mainWord, mainHint, languageWord, languageHint);
            }
        }
    }

    /**
     * This operation converts a string with multiple translations to translations that will be stored in the language
     * component.
     *
     * @param language     is the component in which the translations will be stored.
     * @param mainWords    is an array of words with the same meaning.
     * @param mainHint     is the hint that goes with the main words.
     * @param languageWord is the translation of the main words.
     * @param languageHint is the hint that goes with the language word.
     */
    private static void addMultiple(Language language, String[] mainWords, String mainHint, String languageWord, String languageHint) {
        for (String mainWord : mainWords) {
            if (mainWord.contains("/")) {
                addMultiple(language, mainWord.split("/"), mainHint, languageWord, languageHint);
            } else if (mainWord.contains(";")) {
                addMultiple(language, mainWord.split(";"), mainHint, languageWord, languageHint);
            } else if (mainWord.contains(",")) {
                addMultiple(language, mainWord.split(","), mainHint, languageWord, languageHint);
            } else {
                if (mainWord.charAt(0) == ' ') {
                    mainWord = mainWord.substring(1);
                }
                language.addWord(mainWord, mainHint, languageWord, languageHint);
            }
        }
    }
    //</editor-fold>
    //</editor-fold>

}
