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
public class MensualesRepar {
   private int ID_DESPACHO;
   private String FECHA_HORA_DESPACHO;
   private int MONTO_REPARTO;
   private String DIRECCION_DESPACHO;
   private String COMUNA_DESPACHO;
   private String NOMBRE_CLIENTE;
   private String APELLIDOS_CLIENTE;

    public MensualesRepar() {
    }

    public MensualesRepar(int ID_DESPACHO, String FECHA_HORA_DESPACHO, int MONTO_REPARTO, String DIRECCION_DESPACHO, String COMUNA_DESPACHO, String NOMBRE_CLIENTE, String APELLIDOS_CLIENTE) {
        this.ID_DESPACHO = ID_DESPACHO;
        this.FECHA_HORA_DESPACHO = FECHA_HORA_DESPACHO;
        this.MONTO_REPARTO = MONTO_REPARTO;
        this.DIRECCION_DESPACHO = DIRECCION_DESPACHO;
        this.COMUNA_DESPACHO = COMUNA_DESPACHO;
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
        this.APELLIDOS_CLIENTE = APELLIDOS_CLIENTE;
    }

    public int getID_DESPACHO() {
        return ID_DESPACHO;
    }

    public void setID_DESPACHO(int ID_DESPACHO) {
        this.ID_DESPACHO = ID_DESPACHO;
    }

    public String getFECHA_HORA_DESPACHO() {
        return FECHA_HORA_DESPACHO;
    }

    public void setFECHA_HORA_DESPACHO(String FECHA_HORA_DESPACHO) {
        this.FECHA_HORA_DESPACHO = FECHA_HORA_DESPACHO;
    }

    public int getMONTO_REPARTO() {
        return MONTO_REPARTO;
    }

    public void setMONTO_REPARTO(int MONTO_REPARTO) {
        this.MONTO_REPARTO = MONTO_REPARTO;
    }

    public String getDIRECCION_DESPACHO() {
        return DIRECCION_DESPACHO;
    }

    public void setDIRECCION_DESPACHO(String DIRECCION_DESPACHO) {
        this.DIRECCION_DESPACHO = DIRECCION_DESPACHO;
    }

    public String getCOMUNA_DESPACHO() {
        return COMUNA_DESPACHO;
    }

    public void setCOMUNA_DESPACHO(String COMUNA_DESPACHO) {
        this.COMUNA_DESPACHO = COMUNA_DESPACHO;
    }

    public String getNOMBRE_CLIENTE() {
        return NOMBRE_CLIENTE;
    }

    public void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE) {
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
    }

    public String getAPELLIDOS_CLIENTE() {
        return APELLIDOS_CLIENTE;
    }

    public void setAPELLIDOS_CLIENTE(String APELLIDOS_CLIENTE) {
        this.APELLIDOS_CLIENTE = APELLIDOS_CLIENTE;
    }
   
   
   
    
}
