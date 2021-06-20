/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.nfunk.jep.JEP;

/**
 *
 * @author johnh
 */
public class Functions {

    JEP jep;

    private String funcion = "";
    private double resultado = 0.0;
    private double valorX = 0.0;

    public Functions() {
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public void setValorx(double valorX) {
        this.valorX = valorX;
    }

    public double getResultado() {
        return this.resultado;
    }

    public void Evaluar() {
        this.jep = new JEP();

        this.jep.addStandardFunctions();

        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funcion);
        this.resultado = this.jep.getValue();
    }
}
