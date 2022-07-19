/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

/**
 *
 * @author DAvil
 */
public class MensualesCom {
    private String NOMBRE_PRODUCTO;
    private int MONTO;
    private String FECHA_HORA_COMPRA;

    public MensualesCom() {
    }
    
    public MensualesCom(String NOMBRE_PRODUCTO, int MONTO, String FECHA_HORA_COMPRA) {
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
        this.MONTO = MONTO;
        this.FECHA_HORA_COMPRA = FECHA_HORA_COMPRA;
    }

    public String getNOMBRE_PRODUCTO() {
        return NOMBRE_PRODUCTO;
    }

    public void setNOMBRE_PRODUCTO(String NOMBRE_PRODUCTO) {
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
    }

    public int getMONTO() {
        return MONTO;
    }

    public void setMONTO(int MONTO) {
        this.MONTO = MONTO;
    }

    public String getFECHA_HORA_COMPRA() {
        return FECHA_HORA_COMPRA;
    }

    public void setFECHA_HORA_COMPRA(String FECHA_HORA_COMPRA) {
        this.FECHA_HORA_COMPRA = FECHA_HORA_COMPRA;
    }
    
    
            
}
