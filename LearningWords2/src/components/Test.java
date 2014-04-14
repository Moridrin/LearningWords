//<editor-fold defaultstate="collapsed" desc="Jibberish">
package components;

import components.enums.TestSpeed;
import components.enums.TestType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//</editor-fold>

/**
 * In this class you can find all properties and operations for the Test.
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/14
 */
public class Test {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private TestSpeed testSpeed;
    private TestType testType;
    private Language language;
    private List<Translation> toBeAsked;
    private final List<Translation> toBeRepeated;
    private final Random random;

    //<editor-fold defaultstate="collapsed" desc="CurrentQuestion">
    private Translation currentQuestion;
    private boolean mainToLanguage;
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the main constructor that is called by the singleton (and therefore I can't give it parameters as
     * Language and TestSpeed.
     */
    private Test() {
        this.random = new Random();
        this.language = null;
        this.testSpeed = null;
        this.toBeRepeated = new ArrayList<>();
        this.toBeAsked = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Singleton">
    public static Test getInstance() {
        return TestHolder.INSTANCE;
    }

    private static class TestHolder {

        private static final Test INSTANCE = new Test();
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters">
    //<editor-fold defaultstate="collapsed" desc="getQuestion()">
    public String getQuestion() {
        if (mainToLanguage) {
            return currentQuestion.getMainWord();
        } else {
            return currentQuestion.getLanguageWord();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getQuestionLanguage()">
    public String getQuestionLanguage() {
        if (mainToLanguage) {
            return "Main";
        } else {
            return language.toString();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getAnswerLanguage()">
    public String getAnswerLanguage() {
        if (mainToLanguage) {
            return language.toString();
        } else {
            return "Main";
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getAnswer()">
    public String getAnswer() {
        if (mainToLanguage) {
            return currentQuestion.getLanguageWord();
        } else {
            return currentQuestion.getMainWord();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getHint()">
    public String getHint() {
        if (mainToLanguage) {
            return currentQuestion.getMainHint();
        } else {
            return currentQuestion.getLanguageHint();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="isFinished()">
    public boolean isFinished() {
        if (testSpeed == TestSpeed.Fast) {
            return toBeAsked.isEmpty();
        } else {
            return (toBeAsked.isEmpty() && toBeRepeated.isEmpty());
        }
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setters">
    //<editor-fold defaultstate="collapsed" desc="setLanguage(language)">
    /**
     * This operation sets the language of the Test. Because this is a singleton class, I can't make these variables
     * final, so these can only be set if the current is null, and the given is not.
     *
     * @param language is the language that will be tested.
     */
    public void setLanguage(Language language) {
        if (this.language == null && language != null) {
            this.language = language;
        } else {
            throw new UnsupportedClassVersionError("can't change the speed while testing.");
        }
        toBeAsked = this.language.getAll();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setLanguageAndSpeed(language)">
    /**
     * This operation sets the speed of the Test. Because this is a singleton class, I can't make these variables final,
     * so these can only be set if the current is null, and the given is not.
     *
     * @param testSpeed is the speed in which it will be tested.
     */
    public void setSpeed(TestSpeed testSpeed) {
        if (this.testSpeed == null && testSpeed != null) {
            this.testSpeed = testSpeed;
        } else {
            throw new UnsupportedClassVersionError("can't change the speed while testing.");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setTestSpeed(testSpeed)">
    /**
     * This operation sets the type of the Test. Because this is a singleton class, I can't make these variables
     * final, so this can only be set if the current is null, and the given is not.
     *
     * @param testType is the type in which it will be tested (foreign language to Main, the other way around or both).
     */
    public void setType(TestType testType) {
        if (this.testType == null && testType != null) {
            this.testType = testType;
        } else {
            throw new UnsupportedClassVersionError("can't change the speed while testing.");
        }
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="nextQuestion()">
    /**
     * This sets the next question and all the variables that go with it.
     */
    public void nextQuestion() {
        currentQuestion = toBeAsked.get(random.nextInt(toBeAsked.size()));
        if (testType == TestType.Both) {
            mainToLanguage = random.nextBoolean();
        } else if (testType == TestType.MainToLanguage) {
            mainToLanguage = true;
        } else if (testType == TestType.LanguageToMain) {
            mainToLanguage = false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="submit(answer)">
    /**
     * This removes the current question from the to be asked list, or adds it to the to be repeated list depending on
     * the testSpeed, and if the answer is correct. If this leaves the to be asked list empty it calls the
     *
     * @param answer is the answer as given by the user.
     *
     * @return if the given answer is correct or not.
     */
    public boolean submit(String answer) {
        boolean isCorrect = getAnswer().toLowerCase().equals(answer.toLowerCase());
        if (testSpeed == TestSpeed.Fast) {
            toBeAsked.remove(currentQuestion);
        } else if (testSpeed == TestSpeed.Good) {
            if (isCorrect) {
                toBeAsked.remove(currentQuestion);
            } else {
                toBeRepeated.add(currentQuestion);
            }
        }
        return isCorrect;
    }
    //</editor-fold>
    //</editor-fold>
}
