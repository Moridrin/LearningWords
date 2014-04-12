//<editor-fold defaultstate="collapsed" desc="Jibberish">
package gui;

import components.Language;
import components.Translation;
import connections.DatabaseFile;
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
    TableView<Translation> table;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    //</editor-fold>
    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    @Override
    public void start(Stage stage) {
        language = new Language("ChineseCharacter");

        //<editor-fold defaultstate="collapsed" desc="GUI">
        BorderPane borderPane = new BorderPane();
        //<editor-fold defaultstate="collapsed" desc="Menu">
        MenuBar menuBar = new MenuBar();
        //<editor-fold defaultstate="collapsed" desc="testMenu">
        Menu testMenu = new Menu("Test");
        //<editor-fold defaultstate="collapsed" desc="testMenuStart">
        MenuItem testMenuStart = new MenuItem("Start");
        testMenuStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                startTest();
            }
        });
        testMenu.getItems().add(testMenuStart);
        //</editor-fold>
        menuBar.getMenus().add(testMenu);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="fileMenu">
        Menu fileMenu = new Menu("File");
        //<editor-fold defaultstate="collapsed" desc="fileMenuLoad">
        MenuItem fileMenuLoad = new MenuItem("Load");
        fileMenuLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                language.clear();
                DatabaseFile.load(language);
                table.setItems(language.getObservable());
            }
        });
        fileMenu.getItems().add(fileMenuLoad);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="fileMenuSave">
        MenuItem fileMenuSave = new MenuItem("Save");
        fileMenuSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DatabaseFile.save(language);
            }
        });
        fileMenu.getItems().add(fileMenuSave);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="fileMenuMerge">
        MenuItem fileMenuMerge = new MenuItem("Merge");
        fileMenuMerge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DatabaseFile.merge(language);
            }
        });
        fileMenu.getItems().add(fileMenuMerge);
        //</editor-fold>
        menuBar.getMenus().add(fileMenu);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="databaseMenu">
        Menu databaseMenu = new Menu("Database");
        //<editor-fold defaultstate="collapsed" desc="databaseMenuLoad">
        MenuItem databaseMenuLoad = new MenuItem("Load");
        databaseMenuLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                language.clear();
                DatabaseMySQL.load(language);
                table.setItems(language.getObservable());
            }
        });
        databaseMenu.getItems().add(databaseMenuLoad);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="databaseMenuSave">
        MenuItem databaseMenuSave = new MenuItem("Save");
        databaseMenuSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DatabaseMySQL.save(language);
            }
        });
        databaseMenu.getItems().add(databaseMenuSave);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="databaseMenuMerge">
        MenuItem databaseMenuMerge = new MenuItem("Merge");
        databaseMenuMerge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DatabaseMySQL.merge(language);
            }
        });
        databaseMenu.getItems().add(databaseMenuMerge);
        //</editor-fold>
        menuBar.getMenus().add(databaseMenu);
        //</editor-fold>
        borderPane.setTop(menuBar);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Table">
        table = new TableView<>();
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

        //<editor-fold defaultstate="collapsed" desc="HintColumn">
        TableColumn hintColumn = new TableColumn("Hint");
        hintColumn.setMinWidth(100);
        hintColumn.setCellValueFactory(new PropertyValueFactory<Translation, String>("hintWord"));
        //</editor-fold>
        table.getColumns().addAll(mainColumn, languageColumn, hintColumn);
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
        testGUI.start(new Stage(), language);
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
