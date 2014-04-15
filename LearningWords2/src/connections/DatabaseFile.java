//<editor-fold defaultstate="collapsed" desc="Jibberish">
package connections;

//</editor-fold>
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

/**
 * In this class you can find all properties and operations for DatabaseFile.
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public abstract class DatabaseFile {

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="load(language)">
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
