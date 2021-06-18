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
    
    public void ComenzarTabla(JTable table){
        table.removeAll();
        model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
    }
    
    public void GenerarTablaBiseccion(JTable table, double valorI, double valorS, String funcion, Double restriccion){
        int contador = 0;
        boolean flag = true;
        
        Functions f = new Functions();
        f.setFuncion(funcion);
        
        double xi = valorI, xs = valorS;
        double xm = 0, fxi = 0, fxs = 0, fxm = 0, error = 0;
        String cParada = "";
        
        model = (DefaultTableModel)table.getModel();
        
        while(flag){
            
            xm = (xi+xs) / 2;
            
            if(contador > 0){
                error = Math.abs(xm - Double.valueOf(String.valueOf(model.getValueAt(contador - 1, 3))));
                cParada = (error < restriccion) ? "Verdadero" : "Falso";
            }
            
            f.setValorx(xi);
            f.Evaluar();
            fxi = f.getResultado();
            
            f.setValorx(xs);
            f.Evaluar();
            fxs = f.getResultado();
            
            f.setValorx(xm);
            f.Evaluar();
            fxm = f.getResultado();
            
            if(model.getRowCount() == 0){
                String data[] = {String.valueOf(contador+1), String.valueOf(xi), String.valueOf(xs), String.valueOf(xm), String.valueOf(fxi), 
                    String.valueOf(fxs), String.valueOf(fxm), String.valueOf(""), String.valueOf("")};
                model.addRow(data);
            }
            else{
                String data[] = {String.valueOf(contador+1), String.valueOf(xi), String.valueOf(xs), String.valueOf(xm), String.valueOf(fxi), 
                    String.valueOf(fxs), String.valueOf(fxm), String.valueOf(error), String.valueOf(cParada)};
                model.addRow(data);
            }
            
            if(contador > 0){
                if(cParada.equalsIgnoreCase("Verdadero")) flag = false;
            }
            
            if(fxm < 0 && fxi < 0){
                    xi = xm;
                }
            else{
                xs = xm;
            }
            contador++;
        }
    }
}
