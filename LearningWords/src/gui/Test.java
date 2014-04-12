//<editor-fold defaultstate="collapsed" desc="Jibberish">
package gui;

import components.Language;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//</editor-fold>

/**
 * In this class you can find all properties and operations for Test. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/12
 */
public class Test extends Application {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private Stage STAGE;
    private Language language;
    private List<String> askedMainWords;
    private List<String> askedLanguageWords;
    private Random random = new Random();
    //<editor-fold defaultstate="collapsed" desc="GUI">
    private Label labelLanguageQuestion;
    private Label labelLanguageAnswer;
    private Label labelQuestion;
    private Label labelHint;
    private Button buttonHint;
    private TextField textFieldAnswer;
    private Button buttonSubmit;
    private Label labelCorrect;
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    @Override
    public void start(Stage stage) {
        //<editor-fold defaultstate="collapsed" desc="GUI">
        BorderPane borderPane = new BorderPane();
        //<editor-fold defaultstate="collapsed" desc="VBox">
        VBox vBox = new VBox();
        //<editor-fold defaultstate="collapsed" desc="HBoxDescription">
        HBox hBoxDescription = new HBox();
        //<editor-fold defaultstate="collapsed" desc="LabelLanguageQuestion">
        labelLanguageQuestion = new Label();
        labelLanguageQuestion.setPrefWidth(200);
        hBoxDescription.getChildren().add(labelLanguageQuestion);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="labelLanguageAnswer">
        labelLanguageAnswer = new Label();
        labelLanguageAnswer.setPrefWidth(200);
        hBoxDescription.getChildren().add(labelLanguageAnswer);
        //</editor-fold>
        vBox.getChildren().add(hBoxDescription);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="HBoxQuestion">
        HBox hBoxQuestion = new HBox();
        //<editor-fold defaultstate="collapsed" desc="LabelQuestion">
        labelQuestion = new Label();
        labelQuestion.setPrefWidth(150);
        hBoxQuestion.getChildren().add(labelQuestion);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LabelHint">
        labelHint = new Label();
        labelHint.setPrefWidth(200);
        hBoxQuestion.getChildren().add(labelHint);
        labelHint.setVisible(false);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="ButtonSubmit">
        buttonHint = new Button("Hint");
        buttonHint.setPrefWidth(150);
        buttonHint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                labelHint.setVisible(true);
            }
        });
        hBoxQuestion.getChildren().add(buttonHint);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="TextFieldAnswer">
        textFieldAnswer = new TextField();
        textFieldAnswer.setPrefWidth(200);
        hBoxQuestion.getChildren().add(textFieldAnswer);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="ButtonSubmit">
        buttonSubmit = new Button("Submit");
        buttonSubmit.setPrefWidth(150);
        buttonSubmit.setDefaultButton(true);
        buttonSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                labelHint.setVisible(false);
                if (askedLanguageWords.size() >= language.getLanguageWords().size()
                    && askedMainWords.size() >= language.getMainWords().size()) {
                    STAGE.close();
                } else {
                    if (buttonSubmit.getText().equals("Submit")) {
                        checkQuestion();
                    } else {
                        nextQuestion();
                    }
                }
            }
        });
        hBoxQuestion.getChildren().add(buttonSubmit);
        //</editor-fold>
        vBox.getChildren().add(hBoxQuestion);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LabelCorrect">
        labelCorrect = new Label();
        vBox.getChildren().add(labelCorrect);
        //</editor-fold>
        borderPane.setCenter(vBox);
        //</editor-fold>
        Scene scene = new Scene(borderPane, 400, 100);
        stage.setTitle("Testing " + language.toString());
        stage.setScene(scene);
        stage.show();
        this.STAGE = stage;
        //</editor-fold>
    }

    public void start(Stage stage, Language language) {
        this.language = language;
        start(stage);
        askedMainWords = new ArrayList<>();
        askedLanguageWords = new ArrayList<>();
        nextQuestion();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="checkQuestion()">
    private void checkQuestion() {
        if (labelLanguageQuestion.getText().equals("Main")) {
            if (language.getLanguageWords(labelQuestion.getText()).contains(textFieldAnswer.getText())) {
                labelCorrect.setText("Correct!");
                buttonSubmit.setText("Next");
                textFieldAnswer.setText("");
                askedMainWords.add(labelQuestion.getText());
            } else {
                labelCorrect.setText("Wrong! The correct answer was: " + language.getLanguageWords(labelQuestion.getText()).get(0));
                buttonSubmit.setText("Next");
            }
        } else {
            if (language.getMainWords(labelQuestion.getText()).contains(textFieldAnswer.getText())) {
                labelCorrect.setText("Correct!");
                buttonSubmit.setText("Next");
                textFieldAnswer.setText("");
                askedLanguageWords.add(labelQuestion.getText());
            } else {
                labelCorrect.setText("Wrong! The correct answer was: " + language.getMainWords(labelQuestion.getText()).get(0));
                buttonSubmit.setText("Next");
            }
        }
        if (askedLanguageWords.size() >= language.getLanguageWords().size()
            && askedMainWords.size() >= language.getMainWords().size()) {
            buttonSubmit.setText("Close");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="nextQuestion()">
    private void nextQuestion() {
        boolean randomB;
        if (askedLanguageWords.size() >= language.getLanguageWords().size()) {
            randomB = true;
        } else if (askedMainWords.size() >= language.getMainWords().size()) {
            randomB = false;
        } else {
            randomB = random.nextBoolean();
        }
        textFieldAnswer.setText("");
        labelCorrect.setText("");
        buttonSubmit.setText("Submit");
        String nextQuestion;
        if (randomB) {
            labelLanguageQuestion.setText("Main");
            labelLanguageAnswer.setText(language.toString());
            nextQuestion = language.getRandomMain(askedMainWords);
        } else {
            labelLanguageQuestion.setText(language.toString());
            labelLanguageAnswer.setText("Main");
            nextQuestion = language.getRandomLanguage(askedLanguageWords);
            labelHint.setText(language.getHint(nextQuestion));
        }
        if (nextQuestion == null) {
            STAGE.close();
        }
        labelQuestion.setText(nextQuestion);
    }
    //</editor-fold>

    //</editor-fold>
}
