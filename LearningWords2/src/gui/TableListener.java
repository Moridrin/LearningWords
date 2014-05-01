/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connections.DatabaseMySQL;
import java.sql.Types;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jeroen
 */
public class TableListener implements TableModelListener {

    private static TableModel oldModel;

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
            String oldValue = oldModel.getValueAt(row, column).toString();
            DatabaseMySQL.save(oldValue, newValue, column);
            saveTableModel(newModel);
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
