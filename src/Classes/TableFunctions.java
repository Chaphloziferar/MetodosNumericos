/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    public void InicializarTabla(JTable table, String header[]) {
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.doLayout();

        model = new DefaultTableModel(data, header);
        table.setModel(model);
        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void ComenzarTabla(JTable table) {
        table.removeAll();
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public void GenerarTablaBiseccion(JTable table, double valorI, double valorS, String funcion, Double restriccion) {
        int contador = 0;
        boolean flag = true;

        Functions f = new Functions();
        f.setFuncion(funcion);

        double xi = valorI, xs = valorS;
        double xm = 0, fxi = 0, fxs = 0, fxm = 0, error = 0;
        String cParada = "";

        model = (DefaultTableModel) table.getModel();

        try {
            while (flag) {
                xm = (xi + xs) / 2;

                if (contador > 0) {
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

                if (model.getRowCount() == 0) {
                    String data[] = {String.valueOf(contador + 1), String.valueOf(xi), String.valueOf(xs), String.valueOf(xm), String.valueOf(fxi),
                        String.valueOf(fxs), String.valueOf(fxm), String.valueOf(""), String.valueOf("")};
                    model.addRow(data);
                } else {
                    String data[] = {String.valueOf(contador + 1), String.valueOf(xi), String.valueOf(xs), String.valueOf(xm), String.valueOf(fxi),
                        String.valueOf(fxs), String.valueOf(fxm), String.valueOf(error), String.valueOf(cParada)};
                    model.addRow(data);
                }

                if (contador > 0) {
                    if (cParada.equalsIgnoreCase("Verdadero")) {
                        flag = false;
                    }
                }

                if (fxm < 0 && fxi < 0) {
                    xi = xm;
                } else {
                    xs = xm;
                }

                if (Double.isNaN(xm)) {
                    throw new Exception();
                }

                contador++;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Intervalos no validos", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
            this.ComenzarTabla(table);
        }
    }

    public void GenerarTablaReglaFalsa(JTable table, double valorI, double valorS, String funcion, Double restriccion) {
        int contador = 0;
        boolean flag = true;

        Functions f = new Functions();
        f.setFuncion(funcion);

        double xi = valorI, xs = valorS;
        double xr = 0, fxi = 0, fxs = 0, fxr = 0, error = 0;
        String cParada = "";

        model = (DefaultTableModel) table.getModel();
        try {
            while (flag) {
                f.setValorx(xi);
                f.Evaluar();
                fxi = f.getResultado();

                f.setValorx(xs);
                f.Evaluar();
                fxs = f.getResultado();

                xr = xs - ((fxs * (xs - xi)) / (fxs - fxi));

                f.setValorx(xr);
                f.Evaluar();
                fxr = f.getResultado();

                if (contador > 0) {
                    error = Math.abs(xr - Double.valueOf(String.valueOf(model.getValueAt(contador - 1, 3))));
                    cParada = (error < restriccion) ? "Verdadero" : "Falso";
                }

                if (model.getRowCount() == 0) {
                    String data[] = {String.valueOf(contador + 1), String.valueOf(xi), String.valueOf(xs), String.valueOf(xr), String.valueOf(fxi),
                        String.valueOf(fxs), String.valueOf(fxr), String.valueOf(""), String.valueOf("")};
                    model.addRow(data);
                } else {
                    String data[] = {String.valueOf(contador + 1), String.valueOf(xi), String.valueOf(xs), String.valueOf(xr), String.valueOf(fxi),
                        String.valueOf(fxs), String.valueOf(fxr), String.valueOf(error), String.valueOf(cParada)};
                    model.addRow(data);
                }

                if (contador > 0) {
                    if (cParada.equalsIgnoreCase("Verdadero")) {
                        flag = false;
                    }
                }

                if (fxr < 0 && fxi < 0) {
                    xi = xr;
                } else {
                    xs = xr;
                }

                if (Double.isNaN(xr)) {
                    throw new Exception();
                }

                contador++;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Intervalos no validos", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
            this.ComenzarTabla(table);
        }
    }
    
    public void GenerarTablaSecante(JTable table, double valorI, double valorS, String funcion, Double restriccion) {
        int contador = 0;
        boolean flag = true;

        Functions f = new Functions();
        f.setFuncion(funcion);

        double xi = valorI, xs = valorS;
        double xn = 0, fxi = 0, fxs = 0, fxn = 0, error = 0;
        String cParada = "";

        model = (DefaultTableModel) table.getModel();
        try {
            while (flag) {
                
                f.setValorx(xi);
                f.Evaluar();
                fxi = f.getResultado();

                f.setValorx(xs);
                f.Evaluar();
                fxs = f.getResultado();

                xn = xs - ((fxs * (xs - xi)) / (fxs - fxi));

                f.setValorx(xn);
                f.Evaluar();
                fxn = f.getResultado();

                if (contador > 1) {
                    error = Math.abs(xn - Double.valueOf(String.valueOf(model.getValueAt(contador - 1, 1))));
                    cParada = (error < restriccion) ? "Verdadero" : "Falso";
                }

                if (model.getRowCount() == 0) {
                    String data[] = {String.valueOf(contador + 1), String.valueOf(xi), String.valueOf(fxi), String.valueOf(""), String.valueOf("")};
                    model.addRow(data);
                    
                    contador++;
                    
                    error = Math.abs(xn - Double.valueOf(String.valueOf(model.getValueAt(contador - 1, 1))));
                    cParada = (error < restriccion) ? "Verdadero" : "Falso";
                    
                    String data2[] = {String.valueOf(contador + 1), String.valueOf(xs), String.valueOf(fxs), String.valueOf(error), cParada};
                    model.addRow(data2);
                } else {
                    String data[] = {String.valueOf(contador + 1), String.valueOf(xn), String.valueOf(fxn), String.valueOf(error), String.valueOf(cParada)};
                    model.addRow(data);
                }

                if (contador > 1) {
                    if (cParada.equalsIgnoreCase("Verdadero")) {
                        flag = false;
                    }
                }

                if (Double.isNaN(xn)) {
                    throw new Exception();
                }
                
                xi = xs;
                xs = xn;
                xn = 0;

                contador++;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Intervalos no validos", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
            this.ComenzarTabla(table);
        }
    }
    
    public void GenerarTablaNewtonRaphson(JTable table, double valorI, String funcion, Double restriccion) {
        int contador = 0;
        boolean flag = true;

        Functions f = new Functions();
        f.setFuncion(funcion);
        
        Derivatives d = new Derivatives();
        d.setFuncionADerivar(funcion);
        d.derivar();
        
        Functions fp = new Functions();
        fp.setFuncion(d.getFuncionDerivada());

        double xn = valorI;
        double fxn = 0, fxnp = 0, error = 0;
        String cParada = "";

        model = (DefaultTableModel) table.getModel();
        try {
            while (flag) {
                
                if(contador > 0){
                    xn = xn - (fxn / fxnp);
                }
                
                f.setValorx(xn);
                f.Evaluar();
                fxn = f.getResultado();
                
                fp.setValorx(xn);
                fp.Evaluar();
                fxnp = fp.getResultado();

                if (contador > 0) {
                    error = Math.abs(xn - Double.valueOf(String.valueOf(model.getValueAt(contador - 1, 1))));
                    cParada = (error < restriccion) ? "Verdadero" : "Falso";
                }

                if (model.getRowCount() == 0) {
                    String data[] = {String.valueOf(contador + 1), String.valueOf(xn), String.valueOf(fxn), String.valueOf(fxnp), String.valueOf(""), String.valueOf("")};
                    model.addRow(data);
                } else {
                    String data[] = {String.valueOf(contador + 1), String.valueOf(xn), String.valueOf(fxn), String.valueOf(fxnp), String.valueOf(error), String.valueOf(cParada)};
                    model.addRow(data);
                }

                if (contador > 0) {
                    if (cParada.equalsIgnoreCase("Verdadero")) {
                        flag = false;
                    }
                }

                if (Double.isNaN(xn)) {
                    throw new Exception();
                }

                contador++;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Intervalos no validos", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
            this.ComenzarTabla(table);
        }
    }
}
