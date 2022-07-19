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
public class listaPorProducto {
    private int ID_PRODUCTO;
    private String NOMBRE_PRODUCTO;
    private int ID_COMPRA;
    private int MONTO_PRODUCTO;
    private String FECHA_HORA_COMPRA;

    public listaPorProducto() {
    }

    public listaPorProducto(int ID_PRODUCTO, String NOMBRE_PRODUCTO, int ID_COMPRA, int MONTO_PRODUCTO, String FECHA_HORA_COMPRA) {
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
        this.ID_COMPRA = ID_COMPRA;
        this.MONTO_PRODUCTO = MONTO_PRODUCTO;
        this.FECHA_HORA_COMPRA = FECHA_HORA_COMPRA;
    }

    public int getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(int ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public String getNOMBRE_PRODUCTO() {
        return NOMBRE_PRODUCTO;
    }

    public void setNOMBRE_PRODUCTO(String NOMBRE_PRODUCTO) {
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
    }

    public int getID_COMPRA() {
        return ID_COMPRA;
    }

    public void setID_COMPRA(int ID_COMPRA) {
        this.ID_COMPRA = ID_COMPRA;
    }

    public int getMONTO_PRODUCTO() {
        return MONTO_PRODUCTO;
    }

    public void setMONTO_PRODUCTO(int MONTO_PRODUCTO) {
        this.MONTO_PRODUCTO = MONTO_PRODUCTO;
    }

    public String getFECHA_HORA_COMPRA() {
        return FECHA_HORA_COMPRA;
    }

    public void setFECHA_HORA_COMPRA(String FECHA_HORA_COMPRA) {
        this.FECHA_HORA_COMPRA = FECHA_HORA_COMPRA;
    }
    
    
}
