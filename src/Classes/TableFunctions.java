/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johnh
 */
public class TableFunctions {
    
    DefaultTableModel model;
    String data[][] = {};
    
    public void InicializarTabla(JTable table, String header[]){
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.doLayout();
        
        model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
    
    public void ComenzarTabla(JTable table, double xi, double xs){
        table.removeAll();
        model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
        GenerarTabla(table, xi, xs);
    }
    
    public void GenerarTabla(JTable table, double xi, double xs){
        model = (DefaultTableModel)table.getModel();
        if(model.getRowCount() == 0){
            String data[] = {"1", String.valueOf(xi), String.valueOf(xs), "Xm", "F(Xi)", "F(Xs)", "F(Xm)", "Error", "C.Parada"};
            model.addRow(data);
        }
    }
}
