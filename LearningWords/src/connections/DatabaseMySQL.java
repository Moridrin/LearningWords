//<editor-fold defaultstate="collapsed" desc="Jibberish">
package connections;

//</editor-fold>
import components.Language;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * In this class you can find all properties and operations for DatabaseMySQL. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public abstract class DatabaseMySQL {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    public static final String MAIN_LANGUAGE = "Dutch";
    private static final String DATABASE_NAME = "MPLearningWords";
    private static final String URL = "jdbc:mysql://85.113.237.162:3306/" + DATABASE_NAME + "?characterSetResults=UTF-8&characterEncoding=UTF-8&useUnicode=yes";
    private static final String USER = "MPLearningWords";
    private static final String PASSWORD = "aEysZFVeGH6YBWLc";
    private static Connection conn;
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="load(language)">
    /**
     * This operation loads the translations from the database, and puts them in the Language component.
     *
     * @param language is the Language component where the translations will be stored.
     */
    public static void load(Language language) {
        try {
            PreparedStatement preparedStatement = null;
            String sql = "SELECT * FROM " + DATABASE_NAME + "." + language.toString();
            ResultSet resultSet = null;
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String mainWord = resultSet.getString(MAIN_LANGUAGE);
                String languageWord = resultSet.getString(language.toString());
                String hintWord = resultSet.getString("Hint");
                language.addWord(mainWord, languageWord, hintWord);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="save(language)">
    public static void save(Language language) {
        clear(language);
        for (int i = 0; i < language.getMainWords().size(); i++) {
            try {
                PreparedStatement preparedStatement = null;
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO ");
                sql.append(DATABASE_NAME);
                sql.append(".");
                sql.append(language.toString());
                sql.append("(");
                sql.append(MAIN_LANGUAGE);
                sql.append(", ");
                sql.append(language.toString());
                sql.append(", Hint) VALUES('");
                sql.append(language.getMainWords().get(i));
                sql.append("', '");
                sql.append(language.getLanguageWords().get(i));
                sql.append("', '");
                sql.append(language.getHint(language.getLanguageWords().get(i)));
                sql.append("')");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                preparedStatement = conn.prepareStatement(sql.toString());
                //preparedStatement.setString(1, language.getMainWords().get(i));
                //preparedStatement.setString(2, language.getLanguageWords().get(i));
                //preparedStatement.setString(3, language.getHint(language.getLanguageWords().get(i)));
                preparedStatement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="merge(language)">
    public static void merge(Language language) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="clear()">
    private static void clear(Language language) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM ");
            sql.append(DATABASE_NAME);
            sql.append(".");
            sql.append(language.toString());
            PreparedStatement preparedStatement = null;
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = conn.prepareStatement(sql.toString());
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //</editor-fold>
    //</editor-fold>
}
