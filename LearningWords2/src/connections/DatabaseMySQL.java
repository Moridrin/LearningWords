//<editor-fold defaultstate="collapsed" desc="Jibberish">
package connections;

import components.Language;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

/**
 * In this class you can find all properties and operations for the MySQL Database.
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
    private static Language lastLanguage;
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
                String mainWord = resultSet.getString("Main");
                String mainHint = resultSet.getString("MainHint");
                String languageWord = resultSet.getString("Language");
                String languageHint = resultSet.getString("LanguageHint");
                language.addWord(mainWord, mainHint, languageWord, languageHint);
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
        lastLanguage = language;
        LastUsed.setLastUsed(LastUsed.MySQL);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="save(language)">
    /**
     * This operation clears the database and stores the language component.
     *
     * @param language the component that will be stored in the database.
     */
    public static void save(Language language) {
        createTable(language);
        clear(language);
        for (int i = 0; i < language.getMainWords().size(); i++) {
            try {
                PreparedStatement preparedStatement = null;
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO ");
                sql.append(DATABASE_NAME);
                sql.append(".");
                sql.append(language.toString());
                sql.append("(Main, MainHint, Language, LanguageHint) VALUES('");
                sql.append(language.getMainWords().get(i));
                sql.append("', '");
                sql.append(language.getMainHint(language.getMainWords().get(i)));
                sql.append("', '");
                sql.append(language.getLanguageWords().get(i));
                sql.append("', '");
                sql.append(language.getLanguageHint(language.getLanguageWords().get(i)));
                sql.append("')");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                preparedStatement = conn.prepareStatement(sql.toString());
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
        lastLanguage = language;
        LastUsed.setLastUsed(LastUsed.MySQL);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="save(oldValue, newValue, column)">
    /**
     * This operation saves a changed value.
     *
     * @param oldValue is the old value that needs to be changed.
     * @param newValue is the new value that needs to be saved.
     * @param column   is the column in which this variable needs to be changed.
     */
    public static void save(String oldValue, String newValue, int column) {
        try {
            PreparedStatement preparedStatement = null;
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE ");
            sql.append(DATABASE_NAME);
            sql.append(".");
            sql.append(lastLanguage.toString());
            switch (column) {
                case 0: {
                    sql.append(" SET Main='");
                    sql.append(newValue);
                    sql.append("' WHERE Main='");
                    sql.append(oldValue);
                    sql.append("'");
                    break;
                }
                case 1: {
                    sql.append(" SET MainHint='");
                    sql.append(newValue);
                    sql.append("' WHERE MainHint='");
                    sql.append(oldValue);
                    sql.append("'");
                    break;
                }
                case 2: {
                    sql.append(" SET Language='");
                    sql.append(newValue);
                    sql.append("' WHERE Language='");
                    sql.append(oldValue);
                    sql.append("'");
                    break;
                }
                case 3: {
                    sql.append(" SET LanguageHint='");
                    sql.append(newValue);
                    sql.append("' WHERE LanguageHint='");
                    sql.append(oldValue);
                    sql.append("'");
                    break;
                }
            }
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = conn.prepareStatement(sql.toString());
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
        LastUsed.setLastUsed(LastUsed.MySQL);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="clear()">
    /**
     * This operation clears the database (or at least the table that fits the current language).
     *
     * @param language contains the name of the table that needs to be cleared.
     */
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

    //<editor-fold defaultstate="collapsed" desc="createTable()">
    /**
     * This operation creates a new table for this language (if necessary).
     *
     * @param language contains the name of the table.
     */
    private static void createTable(Language language) {
        try {
            PreparedStatement preparedStatement = null;
            String sql = "CREATE TABLE IF NOT EXISTS " + language.toString() + " LIKE MPLearningWords.Template";
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
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
    //</editor-fold>
    //</editor-fold>

}
