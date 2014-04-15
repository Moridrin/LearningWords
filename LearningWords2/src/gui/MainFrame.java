//<editor-fold defaultstate="collapsed" desc="Jibberish">
package gui;

import components.Language;
import components.enums.TestSpeed;
import components.enums.TestType;
import connections.DatabaseFile;
import connections.DatabaseMySQL;
import javax.swing.table.DefaultTableModel;
//</editor-fold>

/**
 *
 * @author J.B.A.J. Berkvens
 */
public class MainFrame extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private Language language;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        language = new Language("ChineseCharacter");
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

        jMenu1 = new javax.swing.JMenu();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuTest = new javax.swing.JMenu();
        jMenuTestFast = new javax.swing.JRadioButtonMenuItem();
        jMenuTestGood = new javax.swing.JRadioButtonMenuItem();
        jSeparatorMenuTestSpeedTipe = new javax.swing.JPopupMenu.Separator();
        jMenuTestBoth = new javax.swing.JMenuItem();
        jMenuTestMainToLanguage = new javax.swing.JMenuItem();
        jMenuTestLanguageToMain = new javax.swing.JMenuItem();
        jMenuFile = new javax.swing.JMenu();
        jMenuFileOpen = new javax.swing.JMenuItem();
        jMenuDatabase = new javax.swing.JMenu();
        jMenuDatabaseLoad = new javax.swing.JMenuItem();
        jMenuDatabaseSave = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Main", "Hint", "Language", "Hint"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jMenuTest.setText("Test");

        jMenuTestFast.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuTestFast.setSelected(true);
        jMenuTestFast.setText("Fast");
        jMenuTestFast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTestFastActionPerformed(evt);
            }
        });
        jMenuTest.add(jMenuTestFast);

        jMenuTestGood.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuTestGood.setText("Good");
        jMenuTestGood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTestGoodActionPerformed(evt);
            }
        });
        jMenuTest.add(jMenuTestGood);
        jMenuTest.add(jSeparatorMenuTestSpeedTipe);

        jMenuTestBoth.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuTestBoth.setText("Both");
        jMenuTestBoth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTestBothActionPerformed(evt);
            }
        });
        jMenuTest.add(jMenuTestBoth);

        jMenuTestMainToLanguage.setText("Main To Language");
        jMenuTestMainToLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTestMainToLanguageActionPerformed(evt);
            }
        });
        jMenuTest.add(jMenuTestMainToLanguage);

        jMenuTestLanguageToMain.setText("Language To Main");
        jMenuTestLanguageToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTestLanguageToMainActionPerformed(evt);
            }
        });
        jMenuTest.add(jMenuTestLanguageToMain);

        jMenuBar1.add(jMenuTest);

        jMenuFile.setText("File");

        jMenuFileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuFileOpen.setText("Open");
        jMenuFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuFileOpen);

        jMenuBar1.add(jMenuFile);

        jMenuDatabase.setText("Database");

        jMenuDatabaseLoad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuDatabaseLoad.setText("Load");
        jMenuDatabaseLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDatabaseLoadActionPerformed(evt);
            }
        });
        jMenuDatabase.add(jMenuDatabaseLoad);

        jMenuDatabaseSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuDatabaseSave.setText("Save");
        jMenuDatabaseSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDatabaseSaveActionPerformed(evt);
            }
        });
        jMenuDatabase.add(jMenuDatabaseSave);

        jMenuBar1.add(jMenuDatabase);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //</editor-fold>

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Menu File Open">
    private void jMenuFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileOpenActionPerformed
        DatabaseFile.load(language, this);
        updateTable();
    }//GEN-LAST:event_jMenuFileOpenActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Menu Database Load">
    private void jMenuDatabaseLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDatabaseLoadActionPerformed
        DatabaseMySQL.load(language);
        updateTable();
    }//GEN-LAST:event_jMenuDatabaseLoadActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Menu Database Save">
    private void jMenuDatabaseSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDatabaseSaveActionPerformed
        DatabaseMySQL.save(language);
    }//GEN-LAST:event_jMenuDatabaseSaveActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Menu Test Fast">
    private void jMenuTestFastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTestFastActionPerformed
        jMenuTestFast.setSelected(true);
        jMenuTestGood.setSelected(false);
    }//GEN-LAST:event_jMenuTestFastActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Menu Test Good">
    private void jMenuTestGoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTestGoodActionPerformed
        jMenuTestGood.setSelected(true);
        jMenuTestFast.setSelected(false);
    }//GEN-LAST:event_jMenuTestGoodActionPerformed

    private void jMenuTestBothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTestBothActionPerformed
        if (jMenuTestFast.isSelected()) {
            TestFrame testFrame = new TestFrame(language, TestSpeed.Fast, TestType.Both);
            testFrame.setVisible(true);
        } else {
            TestFrame testFrame = new TestFrame(language, TestSpeed.Good, TestType.Both);
            testFrame.setVisible(true);
        }
    }//GEN-LAST:event_jMenuTestBothActionPerformed

    private void jMenuTestMainToLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTestMainToLanguageActionPerformed
        // TODO add your handling code here:
        if (jMenuTestFast.isSelected()) {
            TestFrame testFrame = new TestFrame(language, TestSpeed.Fast, TestType.MainToLanguage);
            testFrame.setVisible(true);
        } else {
            TestFrame testFrame = new TestFrame(language, TestSpeed.Good, TestType.MainToLanguage);
            testFrame.setVisible(true);
        }
    }//GEN-LAST:event_jMenuTestMainToLanguageActionPerformed

    private void jMenuTestLanguageToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTestLanguageToMainActionPerformed
        if (jMenuTestFast.isSelected()) {
            TestFrame testFrame = new TestFrame(language, TestSpeed.Fast, TestType.LanguageToMain);
            testFrame.setVisible(true);
        } else {
            TestFrame testFrame = new TestFrame(language, TestSpeed.Good, TestType.LanguageToMain);
            testFrame.setVisible(true);
        }
    }//GEN-LAST:event_jMenuTestLanguageToMainActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Static Main">
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Generated Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuDatabase;
    private javax.swing.JMenuItem jMenuDatabaseLoad;
    private javax.swing.JMenuItem jMenuDatabaseSave;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuFileOpen;
    private javax.swing.JMenu jMenuTest;
    private javax.swing.JMenuItem jMenuTestBoth;
    private javax.swing.JRadioButtonMenuItem jMenuTestFast;
    private javax.swing.JRadioButtonMenuItem jMenuTestGood;
    private javax.swing.JMenuItem jMenuTestLanguageToMain;
    private javax.swing.JMenuItem jMenuTestMainToLanguage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparatorMenuTestSpeedTipe;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Update Table">
    private void updateTable() {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        for (int i = 0; i < language.getMainWords().size(); i++) {
            Object[] row = new Object[4];
            row[0] = language.getMainWords().get(i);
            row[1] = language.getMainHint(language.getMainWords().get(i));
            row[2] = language.getLanguageWords().get(i);
            row[3] = language.getLanguageHint(language.getLanguageWords().get(i));
            tableModel.addRow(row);
        }
        jTable.setModel(tableModel);
    }
    //</editor-fold>
    //</editor-fold>
}
