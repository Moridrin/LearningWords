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
    private List<String> wrongMainWords;
    private List<String> askedLanguageWords;
    private List<String> wrongLanguageWords;
    private final Random random = new Random();
    private String testType;
    private String testSpeed;
    private boolean loopingWrongAnswers = false;
    //<editor-fold defaultstate="collapsed" desc="GUI">
    private Label labelLanguageQuestion;
    private Label labelLanguageAnswer;
    private Label labelQuestion;
    private Label labelHint;
    private Button buttonHint;
    private TextField textFieldAnswer;
    private Button buttonSubmit;
    private Label labelCorrectAnswer;
    private Label labelCorrect;
    private Label labelWrong;
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    @Override
    public void start(Stage stage) {
        //<editor-fold defaultstate="collapsed" desc="GUI">
        BorderPane borderPane = new BorderPane();
        //<editor-fold defaultstate="collapsed" desc="HBoxMain">
        HBox hBoxMain = new HBox();
        //<editor-fold defaultstate="collapsed" desc="VBoxQuestion">
        VBox vBoxQuestion = new VBox();
        //<editor-fold defaultstate="collapsed" desc="LabelLanguageQuestion">
        labelLanguageQuestion = new Label();
        labelLanguageQuestion.setPrefWidth(200);
        vBoxQuestion.getChildren().add(labelLanguageQuestion);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LabelQuestion">
        labelQuestion = new Label();
        labelQuestion.setPrefWidth(200);
        labelQuestion.setMinWidth(200);
        vBoxQuestion.getChildren().add(labelQuestion);
        //</editor-fold>
        hBoxMain.getChildren().add(vBoxQuestion);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="VBoxLabelHint">
        VBox vBoxLabelHint = new VBox();
        //<editor-fold defaultstate="collapsed" desc="Blank">
        vBoxLabelHint.getChildren().add(new Label());
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LabelHint">
        labelHint = new Label();
        labelHint.setPrefWidth(150);
        labelHint.setMinWidth(150);
        vBoxLabelHint.getChildren().add(labelHint);
        labelHint.setVisible(false);
        //</editor-fold>
        hBoxMain.getChildren().add(vBoxLabelHint);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="VBoxButtonHint">
        VBox vBoxButtonHint = new VBox();
        //<editor-fold defaultstate="collapsed" desc="Blank">
        vBoxButtonHint.getChildren().add(new Label());
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="ButtonHint">
        buttonHint = new Button("Hint");
        buttonHint.setPrefWidth(70);
        buttonHint.setMaxWidth(70);
        buttonHint.setMinWidth(70);
        buttonHint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                labelHint.setVisible(true);
            }
        });
        vBoxButtonHint.getChildren().add(buttonHint);
        //</editor-fold>
        hBoxMain.getChildren().add(vBoxButtonHint);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="VBoxAnswer">
        VBox vBoxAnswer = new VBox();
        //<editor-fold defaultstate="collapsed" desc="labelLanguageAnswer">
        labelLanguageAnswer = new Label();
        labelLanguageAnswer.setPrefWidth(200);
        vBoxAnswer.getChildren().add(labelLanguageAnswer);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="TextFieldAnswer">
        textFieldAnswer = new TextField();
        textFieldAnswer.setPrefWidth(200);
        textFieldAnswer.setMinWidth(200);
        vBoxAnswer.getChildren().add(textFieldAnswer);
        //</editor-fold>
        hBoxMain.getChildren().add(vBoxAnswer);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="VBoxButtonSubmit">
        VBox vBoxButtonSubmit = new VBox();
        //<editor-fold defaultstate="collapsed" desc="Blank">
        vBoxButtonSubmit.getChildren().add(new Label());
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="ButtonSubmit">
        buttonSubmit = new Button("Submit");
        buttonSubmit.setPrefWidth(70);
        buttonSubmit.setMaxWidth(70);
        buttonSubmit.setMinWidth(70);
        buttonSubmit.setDefaultButton(true);
        buttonSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                labelHint.setVisible(false);
                if (askedLanguageWords.size() >= language.getLanguageWords().size()
                    && askedMainWords.size() >= language.getMainWords().size()) {
                    STAGE.close();
                } else {
                    switch (buttonSubmit.getText()) {
                        case "Submit": {
                            checkQuestion();
                            break;
                        }
                        case "Close": {
                            STAGE.close();
                            break;
                        }
                        default: {
                            nextQuestion();
                            break;
                        }
                    }
                }
            }
        });
        vBoxButtonSubmit.getChildren().add(buttonSubmit);
        //</editor-fold>
        hBoxMain.getChildren().add(vBoxButtonSubmit);
        //</editor-fold>
        borderPane.setCenter(hBoxMain);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="HBoxScore">
        HBox hBoxScore = new HBox();
        //<editor-fold defaultstate="collapsed" desc="LabelCorrectAnswer">
        labelCorrectAnswer = new Label();
        labelCorrectAnswer.setPrefWidth(650);
        labelCorrectAnswer.setMinWidth(500);
        hBoxScore.getChildren().add(labelCorrectAnswer);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LabelCorrect">
        labelCorrect = new Label("0");
        labelCorrect.setPrefWidth(25);
        labelCorrect.setMinWidth(25);
        hBoxScore.getChildren().add(labelCorrect);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LabelWrong">
        labelWrong = new Label("0");
        labelWrong.setPrefWidth(25);
        labelWrong.setMinWidth(25);
        hBoxScore.getChildren().add(labelWrong);
        //</editor-fold>
        borderPane.setBottom(hBoxScore);
        //</editor-fold>
        Scene scene = new Scene(borderPane, 700, 75);
        stage.setTitle("Testing " + language.toString());
        stage.setScene(scene);
        stage.show();
        this.STAGE = stage;
        //</editor-fold>
    }

    public void start(Stage stage, Language language, String testType, String testSpeed) {
        this.testType = testType;
        this.testSpeed = testSpeed;
        this.language = language;
        start(stage);
        askedMainWords = new ArrayList<>();
        askedLanguageWords = new ArrayList<>();
        wrongMainWords = new ArrayList<>();
        wrongLanguageWords = new ArrayList<>();
        nextQuestion();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="checkQuestion()">
    private void checkQuestion() {
        buttonSubmit.setText("Next");

        //<editor-fold defaultstate="collapsed" desc="Main To Language">
        if (labelLanguageQuestion.getText().equals("Main")) {
            if (textFieldAnswer.getText().equals("")) {
                setWrong(true);
            } else {
                for (String possibleAnswer : language.getLanguageWords(labelQuestion.getText())) {
                    if (possibleAnswer.toLowerCase().contains(textFieldAnswer.getText().toLowerCase())) {
                        setCorrect(true);
                        break;
                    } else {
                        setWrong(true);
                    }
                }
            }
        }//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Language To Main">
        else {
            if (textFieldAnswer.getText().equals("")) {
                setWrong(false);
            } else {
                for (String possibleAnswer : language.getMainWords(labelQuestion.getText())) {
                    if (possibleAnswer.toLowerCase().contains(textFieldAnswer.getText().toLowerCase())) {
                        setCorrect(false);
                    } else {
                        setWrong(false);
                    }
                }
            }
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Test Finished">
        switch (testType) {
            case "Both": {
                if (askedLanguageWords.size() >= language.getLanguageWords().size()
                    && askedMainWords.size() >= language.getMainWords().size()) {
                    if ((wrongMainWords.isEmpty() && wrongLanguageWords.isEmpty())) {
                        buttonSubmit.setText("Close");
                    } else if (!loopingWrongAnswers) {
                        loopingWrongAnswers = true;
                    }
                }
                break;
            }
            case "MainToLanguage": {
                if (askedMainWords.size() >= language.getMainWords().size()) {
                    if (wrongMainWords.isEmpty()) {
                        buttonSubmit.setText("Close");
                    } else if (!loopingWrongAnswers) {
                        loopingWrongAnswers = true;
                    }
                }
                break;
            }
            case "LanguageToMain": {
                if (askedLanguageWords.size() >= language.getLanguageWords().size()) {
                    if (wrongLanguageWords.isEmpty()) {
                        buttonSubmit.setText("Close");
                    } else if (!loopingWrongAnswers) {
                        loopingWrongAnswers = true;
                    }
                }
                break;
            }
        }
        //</editor-fold>
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setWrong(correctAnswer)">
    private void setWrong(boolean mainOrLanguage) {
        String correctAnswer = "";
        if (mainOrLanguage) {
            correctAnswer = language.getLanguageWords(labelQuestion.getText()).get(0);
            if (!wrongMainWords.contains(labelQuestion.getText())) {
                wrongMainWords.add(labelQuestion.getText());
            }
        } else {
            correctAnswer = language.getMainWords(labelQuestion.getText()).get(0);
            if (!wrongLanguageWords.contains(labelQuestion.getText())) {
                wrongLanguageWords.add(labelQuestion.getText());
            }
        }
        labelCorrectAnswer.setText("Wrong! The correct answer was: " + correctAnswer);
        int wrongCount = Integer.parseInt(labelWrong.getText());
        wrongCount++;
        labelWrong.setText(wrongCount + "");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setCorrect()">
    private void setCorrect(boolean mainOrLanguage) {
        if (!loopingWrongAnswers) {
            if (mainOrLanguage) {
                askedMainWords.add(labelQuestion.getText());
            } else {
                askedLanguageWords.add(labelQuestion.getText());
            }
        } else {
            if (mainOrLanguage) {
                wrongMainWords.remove(labelQuestion.getText());
            } else {
                wrongLanguageWords.remove(labelQuestion.getText());
            }
        }
        int correctCount = Integer.parseInt(labelCorrect.getText());
        correctCount++;
        labelCorrect.setText(correctCount + "");
        labelCorrectAnswer.setText("Correct!");
        textFieldAnswer.setText("");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="nextQuestion()">
    private void nextQuestion() {
        //<editor-fold defaultstate="collapsed" desc="Initialize">
        textFieldAnswer.setText("");
        labelCorrectAnswer.setText("");
        buttonSubmit.setText("Submit");
        boolean mainOrLanguage = true;
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Determine Language or Main">
        switch (testType) {
            case "Both": {
                if (askedLanguageWords.size() >= language.getLanguageWords().size()) {
                    mainOrLanguage = true;
                } else if (askedMainWords.size() >= language.getMainWords().size()) {
                    mainOrLanguage = false;
                } else {
                    mainOrLanguage = random.nextBoolean();
                }
                break;
            }
            case "MainToLanguage": {
                mainOrLanguage = true;
                break;
            }
            case "LanguageToMain": {
                mainOrLanguage = false;
                break;
            }
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Get en Set Question">
        String nextQuestion;
        if (!loopingWrongAnswers) {
            if (mainOrLanguage) {
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
        } else {
            if (mainOrLanguage) {
                labelLanguageQuestion.setText("Main");
                labelLanguageAnswer.setText(language.toString());
                List<String> wordsNotToAsk = new ArrayList<>();
                wordsNotToAsk = language.getMainWords();
                wordsNotToAsk.removeAll(wrongMainWords);
                nextQuestion = language.getRandomMain(wordsNotToAsk);
            } else {
                labelLanguageQuestion.setText(language.toString());
                labelLanguageAnswer.setText("Main");
                List<String> wordsNotToAsk = new ArrayList<>();
                wordsNotToAsk = language.getLanguageWords();
                wordsNotToAsk.removeAll(wrongLanguageWords);
                nextQuestion = language.getRandomLanguage(wordsNotToAsk);
                labelHint.setText(language.getHint(nextQuestion));
            }
            if (nextQuestion == null) {
                STAGE.close();
            }
        }
        labelQuestion.setText(nextQuestion);
        //</editor-fold>
    }
    //</editor-fold>

    //</editor-fold>
}
