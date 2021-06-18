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
    
    private String error = "";
    
    public Functions(){}
    
    public void setFuncion(String funcion){
        this.funcion = funcion;
    }
    
    public void setValorx(double valorX){
        this.valorX = valorX;
    }
    
    public double getResultado(){
        return this.resultado;
    }
    
    public String getError(){
        return this.error;
    }
    
    public void Evaluar(){
        this.jep = new JEP();
            
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funcion);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError())?"Existe un error":"No hay Error";
    }
}
