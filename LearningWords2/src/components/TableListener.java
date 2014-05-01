/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import connections.DatabaseMySQL;
import connections.enums.LastUsed;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jeroen
 */
public class TableListener implements TableModelListener {

    private static DefaultTableModel oldModel;
    private static Language language;

    public static void setLanguage(Language language) {
        TableListener.language = language;
    }

    private TableListener() {
    }

    public static TableListener getInstance() {
        return TableListenerHolder.INSTANCE;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel newModel = (TableModel) e.getSource();
        if (column >= 0) {
            String newValue = newModel.getValueAt(row, column).toString();
            String oldValue = (String) oldModel.getValueAt(row, column);
            language.change(oldValue, newValue, row, column);
            if (oldValue != null && LastUsed.getLastUsed() == LastUsed.MySQL) {
                DatabaseMySQL.save(oldValue, newValue, column);
            }
            saveTableModel(newModel);
        }
    }

    public static void addRows(int amount) {
        for (int i = 0; i < amount; i++) {
            oldModel.addRow(new Object[oldModel.getColumnCount()]);
        }
    }

    public static void saveTableModel(TableModel tableModel) {
        oldModel = new DefaultTableModel(tableModel.getRowCount(), tableModel.getColumnCount());
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                oldModel.setValueAt(tableModel.getValueAt(i, j), i, j);
            }
        }

    }

    private static class TableListenerHolder {

        private static final TableListener INSTANCE = new TableListener();
    }
}
