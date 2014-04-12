//<editor-fold defaultstate="collapsed" desc="Jibberish">
package learningwords;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//</editor-fold>

/**
 * In this class you can find all properties and operations for LearningWords. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public class LearningWords extends Application {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private Stage STAGE;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    //</editor-fold>
    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    @Override
    public void start(Stage stage) {
        //<editor-fold defaultstate="collapsed" desc="GUI">
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 300, 250);
        stage.setTitle("Learning Words!");
        stage.setScene(scene);
        stage.show();
        this.STAGE = stage;
        //</editor-fold>
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="main(args)">
    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the
     * application can not be launched through deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores
     * main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    //</editor-fold>
    //</editor-fold>
}
