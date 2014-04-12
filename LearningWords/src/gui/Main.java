//<editor-fold defaultstate="collapsed" desc="Jibberish">
package gui;

import components.Language;
import components.Translation;
import connections.DatabaseMySQL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//</editor-fold>

/**
 * In this class you can find all properties and operations for Main. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public class Main extends Application {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private Stage STAGE;
    Language language;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    //</editor-fold>
    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    @Override
    public void start(Stage stage) {
        language = new Language("ChineseCharacter");
        DatabaseMySQL.load(language);

        //<editor-fold defaultstate="collapsed" desc="GUI">
        BorderPane borderPane = new BorderPane();
        //<editor-fold defaultstate="collapsed" desc="Menu">
        MenuBar menuBar = new MenuBar();
        Menu mainMenu = new Menu("Test");
        MenuItem mainMenuItem = new MenuItem("Start");
        mainMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                startTest();
            }
        });
        mainMenu.getItems().add(mainMenuItem);
        menuBar.getMenus().add(mainMenu);
        borderPane.setTop(menuBar);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Table">
        TableView<Translation> table = new TableView<>();
        table.setEditable(true);
        //<editor-fold defaultstate="collapsed" desc="MainColumn">
        TableColumn mainColumn = new TableColumn(DatabaseMySQL.MAIN_LANGUAGE);
        mainColumn.setMinWidth(100);
        mainColumn.setCellValueFactory(new PropertyValueFactory<Translation, String>("mainWord"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LanguageColumn">
        TableColumn languageColumn = new TableColumn(language.toString());
        languageColumn.setMinWidth(100);
        languageColumn.setCellValueFactory(new PropertyValueFactory<Translation, String>("languageWord"));
        //</editor-fold>
        table.getColumns().addAll(mainColumn, languageColumn);
        table.setItems(language.getObservable());
        borderPane.setCenter(table);
        //</editor-fold>
        Scene scene = new Scene(borderPane, 300, 250);
        stage.setTitle("Learning Words!");
        stage.setScene(scene);
        stage.show();
        this.STAGE = stage;
        //</editor-fold>
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="startTest()">
    private void startTest() {
        Test testGUI = new Test();
        testGUI.start(STAGE);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="main(args)">
    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the
     * application can not be launched through deployment artifacts, e.g., in IDEs with limited FX support. NetBeans
     * ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    //</editor-fold>
    //</editor-fold>
}
