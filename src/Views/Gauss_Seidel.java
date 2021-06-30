/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.TrayIcon;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rolavalehe
 */
public class Gauss_Seidel extends javax.swing.JFrame {

    /**
     * Creates new form Sistema3x3
     */
    
    DefaultTableModel matriz;
    DefaultTableModel iteracion;
    DefaultTableModel resultado;
    DefaultTableModel valores;
    int rango;
    double A[][];
    double B[];
    double X[];
    double tol;
    
    private static DecimalFormat df = new DecimalFormat("0.0000");
    
    public Gauss_Seidel() {
        initComponents();
        setLocationRelativeTo(null);
        btnCalcular.setEnabled(false);
        
        ((DefaultTableCellRenderer) Tabla_Matriz.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) Tabla_Resultado.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) Tabla_valores.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        //Ajuste de tamaño de celdas
        Tabla_Matriz.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tabla_Matriz.doLayout();
        Tabla_Matriz.setRowMargin(10);
        Tabla_Matriz.setRowHeight(50);
        Tabla_Iteraciones.setRowMargin(0);
        Tabla_Iteraciones.setRowHeight(50);
        Tabla_Resultado.setRowMargin(10);
        Tabla_Resultado.setRowHeight(50);
        Tabla_valores.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tabla_valores.setRowHeight(40);
        
        //Inivializacion de los modelos de tabla
        matriz = new DefaultTableModel(new Object[] {"X1"} , 0);
        iteracion = new DefaultTableModel(new Object[] {""} , 0);
        resultado = new DefaultTableModel(new Object[] {"B"} , 0);
        valores = new DefaultTableModel(new Object[] {"X1"} , 0);
        
        //Asignacion de modelos de tablas a las tablas
        Tabla_Matriz.setModel(matriz);
        Tabla_Iteraciones.setModel(iteracion);
        Tabla_Resultado.setModel(resultado);
        Tabla_valores.setModel(valores);
        
        this.setTitle("Metodo Gauss-Seidel");
    }
    
    public void startTable() {
        matriz.setColumnCount(0);
        iteracion.setColumnCount(0);
        resultado.setRowCount(0);
        valores.setColumnCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupOpciones = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtOrden = new javax.swing.JTextField();
        btnPreparar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_Resultado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Matriz = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla_valores = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtError = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Iteraciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Gauss-Seidel");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Orden de la matriz");

        txtOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOrdenKeyTyped(evt);
            }
        });

        btnPreparar.setText("Preparar");
        btnPreparar.setToolTipText("");
        btnPreparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrepararActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(btnPreparar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreparar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Tabla_Resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        Tabla_Resultado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tabla_Resultado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabla_Resultado.setRowHeight(30);
        Tabla_Resultado.setSurrendersFocusOnKeystroke(true);
        Tabla_Resultado.getTableHeader().setResizingAllowed(false);
        Tabla_Resultado.getTableHeader().setReorderingAllowed(false);
        Tabla_Resultado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tabla_ResultadoFocusGained(evt);
            }
        });
        Tabla_Resultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tabla_ResultadoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla_Resultado);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("=");
        jLabel3.setToolTipText("");

        Tabla_Matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_Matriz.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tabla_Matriz.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabla_Matriz.setRowHeight(30);
        Tabla_Matriz.setSurrendersFocusOnKeystroke(true);
        Tabla_Matriz.getTableHeader().setResizingAllowed(false);
        Tabla_Matriz.getTableHeader().setReorderingAllowed(false);
        Tabla_Matriz.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tabla_MatrizFocusGained(evt);
            }
        });
        Tabla_Matriz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tabla_MatrizKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla_Matriz);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Tabla_valores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_valores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tabla_valores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabla_valores.setRowHeight(30);
        Tabla_valores.setSurrendersFocusOnKeystroke(true);
        Tabla_valores.getTableHeader().setResizingAllowed(false);
        Tabla_valores.getTableHeader().setReorderingAllowed(false);
        Tabla_valores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tabla_valoresFocusGained(evt);
            }
        });
        Tabla_valores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tabla_valoresKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(Tabla_valores);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tolerancia = 10^-");

        txtError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtError.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtErrorKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Valores iniciales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel5)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Tabla_Iteraciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Tabla_Iteraciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ));
        Tabla_Iteraciones.setEnabled(false);
        Tabla_Iteraciones.setRowHeight(30);
        Tabla_Iteraciones.setShowHorizontalLines(false);
        Tabla_Iteraciones.setShowVerticalLines(false);
        jScrollPane1.setViewportView(Tabla_Iteraciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Main m = new Main();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnPrepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrepararActionPerformed
        
        if (txtOrden.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar el tamaño de la matriz", "Orden de la matriz nula", JOptionPane.WARNING_MESSAGE);
        }else{
        startTable();
        rango = Integer.parseInt(txtOrden.getText());
        btnCalcular.setEnabled(true);
        PrepararMatrices();
        }
        
        
    }//GEN-LAST:event_btnPrepararActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        A= new double[rango][rango];
        B = new double[rango];
        X = new double[rango];
        tol = Math.pow(10, ((Double.parseDouble(txtError.getText()))*-1));
        
        double Sum[] = new double[rango];
        
        iteracion.setNumRows(0);
        
        if ((Matrizdatosllena() && Matrizresllena())) {
            for (int i = 0; i < rango; i++) {
                for (int j = 0; j < rango; j++) {
                    A[i][j] = Double.parseDouble(Tabla_Matriz.getValueAt(i, j).toString());
                    Sum[i] = Sum[i]+A[i][j];
                }
                B[i] = Double.parseDouble(Tabla_Resultado.getValueAt(i, 0).toString());
                X[i] = Double.parseDouble(Tabla_valores.getValueAt(0, i).toString());
                Sum[i] = Sum[i]-A[i][i];
            }
            
            for (int i = 0; i < rango; i++) {
                if (A[i][i] < Sum[i]) {
                    JOptionPane.showMessageDialog(rootPane, "La matriz no es dominante");
                    break;
                } else {
                    if (i == (rango-1)) {
                        btnCalcular.setEnabled(true);
                        
                        int iter = 1;
                        double temp;
                        double err[][] = new double[2][rango];
                        double value = 1;
        
                        do {
                            if (iter == 1) {
                                for (int j = 0; j < rango; j++) {
                                    err[0][j] = X[j];
                                }
                            }
                            
                                for (int q = 0; q < rango; q++) {
                                    temp = 0;
                                    for (int j = 0; j < rango; j++) {
                                        if (q != j) {
                                            temp = temp + (A[q][j]*X[j]);
                                        }
                                    }
                                    X[q] = (((temp*-1)+B[q])/A[q][q]);

                                }
                
                                iteracion.addRow(new Object[]{null});
                                iteracion.setValueAt(iter, (iter-1), 0);
                                for (int q = 1; q < (rango+1); q++) {
                                    iteracion.setValueAt(df.format(X[q-1]), (iter-1), q);
                                    err[1][q-1] = X[q-1];
                                }
                                value = ErrorValue(err);
                                iteracion.setValueAt(df.format(value), (iter-1), (rango+1));
            
                                for (int q = 0; q < rango; q++) {
                                    err[0][q] = err[1][q];
                                }                           
                            iter++;
                        } while (value > tol);
                        
                    }
                }
            }
        }

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void Tabla_MatrizFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tabla_MatrizFocusGained
        // TODO add your handling code here:
        if (Tabla_valores.isEditing() ) {

            Tabla_valores.getCellEditor().stopCellEditing();
        }else {
            if (Tabla_Resultado.isEditing()) {
                Tabla_Resultado.getCellEditor().stopCellEditing();
            }
        }
    }//GEN-LAST:event_Tabla_MatrizFocusGained

    private void Tabla_MatrizKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_MatrizKeyPressed
        // TODO add your handling code here:
        char val = evt.getKeyChar();

        if ((val<'0' || val>'9') && val>'-' ) evt.consume();
    }//GEN-LAST:event_Tabla_MatrizKeyPressed

    private void Tabla_ResultadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tabla_ResultadoFocusGained
        // TODO add your handling code here:
        if (Tabla_Matriz.isEditing() ) {

            Tabla_Matriz.getCellEditor().stopCellEditing();
        }else {
            if (Tabla_valores.isEditing()) {
                Tabla_valores.getCellEditor().stopCellEditing();
            }
        }
    }//GEN-LAST:event_Tabla_ResultadoFocusGained

    private void Tabla_ResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_ResultadoKeyPressed
        // TODO add your handling code here:
        char val = evt.getKeyChar();

        if ((val<'0' || val>'9') && val>'-' ) evt.consume();
    }//GEN-LAST:event_Tabla_ResultadoKeyPressed

    private void txtErrorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtErrorKeyTyped
        char c = evt.getKeyChar();

        if(((c < '0') || (c > '9')) && (c != '\b') && (c != 45))
        evt.consume();
    }//GEN-LAST:event_txtErrorKeyTyped

    private void txtOrdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrdenKeyTyped
        // TODO add your handling code here:
        char val = evt.getKeyChar();

        if (val<'0' || val>'9') evt.consume();

    }//GEN-LAST:event_txtOrdenKeyTyped

    private void Tabla_valoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_valoresKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if(((c < '0') || (c > '9')) && (c != '\b') && (c != 45))
        evt.consume();
    }//GEN-LAST:event_Tabla_valoresKeyPressed

    private void Tabla_valoresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tabla_valoresFocusGained
        // TODO add your handling code here:
        if (Tabla_Matriz.isEditing() ) {

            Tabla_Matriz.getCellEditor().stopCellEditing();
        }else {
            if (Tabla_Resultado.isEditing()) {
                Tabla_Resultado.getCellEditor().stopCellEditing();
            }
        }
    }//GEN-LAST:event_Tabla_valoresFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (doubleroduced in Java SE 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(Gauss_Seidel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gauss_Seidel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gauss_Seidel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gauss_Seidel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gauss_Seidel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupOpciones;
    private javax.swing.JTable Tabla_Iteraciones;
    private javax.swing.JTable Tabla_Matriz;
    private javax.swing.JTable Tabla_Resultado;
    private javax.swing.JTable Tabla_valores;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnPreparar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField txtError;
    private javax.swing.JTextField txtOrden;
    // End of variables declaration//GEN-END:variables

private void PrepararMatrices(){
     if (rango > 7) {
            JOptionPane.showMessageDialog(rootPane, "No se puede generar una matriz de orden superior al 7");
        }else{
            for (int i = 0; i < rango; i++) {
                matriz.addColumn("X"+(i+1));
                valores.addColumn("X"+(i+1));
            }
            for (int i = 0; i < (rango+2); i++) {
                if (i == 0) {
                    iteracion.addColumn("");
                } else {
                    if (i == (rango+1)) {
                        iteracion.addColumn("Error");
                    } else {
                        iteracion.addColumn("X"+i);
                    }
                }
            }
            matriz.setNumRows(rango);
            resultado.setNumRows(rango);
            valores.setNumRows(1);
        }
}

private double ErrorValue(double[][] E){
    
    double abs[] = new double[rango];
    double res = 0;
    
    for (int i = 0; i < rango; i++) {
       abs[i] = Math.abs(E[1][i]-E[0][i]); 
    }
    
    for (int i = 0; i < rango; i++) {
        if (abs[i] > res) {
            res = abs[i];
        }
    }

    return res;
}

public boolean Matrizdatosllena(){
    
    for (int i = 0; i < rango; i++) {
        for (int j = 0; j < rango; j++) {
            if (Tabla_Matriz.getValueAt(i, j) ==  null) {
                JOptionPane.showMessageDialog(rootPane, "No puede haber valores vacios en la matriz de valores", "Elementos faltantes", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
    }
    return true;
}

//Validacion de que no halla elementos null en la matriz de resultados
public boolean Matrizresllena(){
    
    for (int i = 0; i < rango; i++) {
        if (Tabla_Resultado.getValueAt(i, 0) ==  null) {
            JOptionPane.showMessageDialog(rootPane, "No puede haber valores vacios en la matriz de resultados", "Elementos faltantes", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            if(Tabla_valores.getValueAt(0, i) ==  null) {
            JOptionPane.showMessageDialog(rootPane, "No puede haber valores vacios en la matriz de valores iniciales", "Elementos faltantes", JOptionPane.WARNING_MESSAGE);
            return false;
            }
        }
    }
    return true;
}

}

