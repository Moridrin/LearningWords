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
public class DatabaseMySQL {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private Connection conn;
    private final String url;
    private final String user;
    private final String password;
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the constructor for DatabaseMySQL.
     */
    public DatabaseMySQL() {
        this.url = "jdbc:mysql://85.113.238.168:3306/MPLearningWords";
        this.user = "MPLearningWords";
        this.password = "aEysZFVeGH6YBWLc";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="load(language)">
    public void load(Language language) {
        try {
            PreparedStatement preparedStatement;
            String sql = "SELECT * FROM ?;";
            ResultSet resultSet;
            conn = DriverManager.getConnection(url, user, password);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, language.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultSet.getString("");
                resultSet.getString("");
                resultSet.getString("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

    //</editor-fold>
}
