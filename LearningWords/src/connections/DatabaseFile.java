//<editor-fold defaultstate="collapsed" desc="Jibberish">
package connections;

//</editor-fold>
import components.Language;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    public static void load(Language language) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
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
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="save(language)">
    public static void save(Language language) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="merge(language)">
    public static void merge(Language language) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="stringToLanguage">
    private static void stringToLanguage(String string, Language language) {
        String[] entries = string.split("___");
        for (String entry : entries) {
            String[] words = entry.split("---");
            String languageWord = words[0];
            String hintWord = words[1];
            String mainWord = words[2];
            if (mainWord.contains("/")) {
                addMultiple(language, mainWord.split("/"), languageWord, hintWord);
            } else if (mainWord.contains(";")) {
                addMultiple(language, mainWord.split(";"), languageWord, hintWord);
            } else if (mainWord.contains(",")) {
                addMultiple(language, mainWord.split(","), languageWord, hintWord);
            } else {
                language.addWord(mainWord, languageWord, hintWord);
            }
        }
    }

    private static void addMultiple(Language language, String[] mainWords, String languageWord, String hintWord) {
        for (String mainWord : mainWords) {
            if (mainWord.contains("/")) {
                addMultiple(language, mainWord.split("/"), languageWord, hintWord);
            } else if (mainWord.contains(";")) {
                addMultiple(language, mainWord.split(";"), languageWord, hintWord);
            } else if (mainWord.contains(",")) {
                addMultiple(language, mainWord.split(","), languageWord, hintWord);
            } else {
                language.addWord(mainWord, languageWord, hintWord);
            }
        }
    }
    //</editor-fold>
    //</editor-fold>

}
