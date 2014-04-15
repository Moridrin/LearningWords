//<editor-fold defaultstate="collapsed" desc="Jibberish">
package gui;

import components.Language;
import components.Test;
import components.enums.TestSpeed;
import components.enums.TestType;
//</editor-fold>

/**
 *
 * @author J.B.A.J. Berkvens
 */
public class TestFrame extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private final Test test;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(language, testSpeed, testType)">
    /**
     * Creates new form TestFrame
     *
     * @param language
     * @param testSpeed
     * @param testType
     */
    public TestFrame(Language language, TestSpeed testSpeed, TestType testType) {
        initComponents();
        jButtonNext.setVisible(false);
        jButtonClose.setVisible(false);
        test = Test.getInstance();
        test.setLanguage(language);
        test.setSpeed(testSpeed);
        test.setType(testType);
        nextQuestion();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLanguageQuestion = new javax.swing.JLabel();
        jLabelLanguageAnswer = new javax.swing.JLabel();
        jTextFieldAnswer = new javax.swing.JTextField();
        jLabelQuestion = new javax.swing.JLabel();
        jButtonHint = new javax.swing.JButton();
        jLabelHint = new javax.swing.JLabel();
        jButtonSubmit = new javax.swing.JButton();
        jLabelFeedback = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuView = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelLanguageQuestion.setText("LanguageQuestion");

        jLabelLanguageAnswer.setText("LanguageAnswer");

        jLabelQuestion.setText("Question");

        jButtonHint.setText("Hint");
        jButtonHint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHintActionPerformed(evt);
            }
        });

        jLabelHint.setText("hint");

        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jLabelFeedback.setText("Feedback");

        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jMenuView.setText("View");
        jMenuBar1.add(jMenuView);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLanguageQuestion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelQuestion)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonHint)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelHint)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLanguageAnswer)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFeedback)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLanguageQuestion)
                    .addComponent(jLabelLanguageAnswer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuestion)
                    .addComponent(jLabelHint)
                    .addComponent(jButtonHint)
                    .addComponent(jButtonSubmit)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonClose))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabelFeedback)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Button Hint">
    private void jButtonHintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHintActionPerformed
        jLabelHint.setText(test.getHint());
        jLabelHint.setVisible(true);
        jButtonHint.setVisible(false);
    }//GEN-LAST:event_jButtonHintActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Button Submit">
    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        if (test.submit(jTextFieldAnswer.getText())) {
            jLabelFeedback.setText("Correct! (" + test.getAnswer() + ")");
        } else {
            jLabelFeedback.setText("Wrong! (" + test.getAnswer() + ")");
        }
        if (test.isFinished()) {
            jButtonClose.setVisible(true);
            this.rootPane.setDefaultButton(jButtonClose);
            jButtonSubmit.setVisible(false);
        } else {
            jLabelFeedback.setVisible(true);
            jButtonSubmit.setVisible(false);
            jButtonNext.setVisible(true);
            this.rootPane.setDefaultButton(jButtonNext);
        }
    }//GEN-LAST:event_jButtonSubmitActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Button Next">
    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        nextQuestion();
    }//GEN-LAST:event_jButtonNextActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Button Close">
    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Generated Variable">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonHint;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelFeedback;
    private javax.swing.JLabel jLabelHint;
    private javax.swing.JLabel jLabelLanguageAnswer;
    private javax.swing.JLabel jLabelLanguageQuestion;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuView;
    private javax.swing.JTextField jTextFieldAnswer;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="nextQuestion()">
    private void nextQuestion() {
        test.nextQuestion();
        if (test.getHint() != null) {
            jButtonHint.setVisible(true);
        } else {
            jButtonHint.setVisible(false);
        }
        jLabelHint.setVisible(false);
        jButtonNext.setVisible(false);
        jButtonSubmit.setVisible(true);
        this.rootPane.setDefaultButton(jButtonSubmit);
        jLabelFeedback.setVisible(false);
        jLabelQuestion.setText(test.getQuestion());
        jLabelLanguageAnswer.setText(test.getAnswerLanguage());
        jLabelLanguageQuestion.setText(test.getQuestionLanguage());
        jTextFieldAnswer.setText("");
        jTextFieldAnswer.selectAll();
    }
    //</editor-fold>
}