/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.ListaTotalPorRepartidor;
import cl.model.MensualesRepar;
import cl.model.totalesReparto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DAvil
 */
public class DAOtotalReparto extends Conectar{
//    public ArrayList<totalesReparto> listaTotalesReparto(String id_usu){
//        ArrayList<totalesReparto> listatotalReparto = new ArrayList<>();
//
//        totalesReparto totalesrepartido;
//
//        String sql = "SELECT DESPACHA.ID_DESPACHO, DESPACHA.FECHA_HORA_DESPACHO, COMPRA.MONTO_REPARTO, DESPACHA.DIRECCION_DESPACHO, COMUNA.NOMBRE_COMUNA AS COMUNA_DESPACHO, USUARIO.NOMBRE AS NOMBRE_CLIENTE, USUARIO.APELLIDOS AS APELLIDOS_CLIENTE FROM DESPACHA INNER JOIN COMPRA ON DESPACHA.ID_COMPRA = COMPRA.ID_COMPRA INNER JOIN USUARIO ON COMPRA.ID_USUARIO = USUARIO.ID_USUARIO INNER JOIN COMUNA ON USUARIO.ID_COMUNA = COMUNA.ID_COMUNA INNER JOIN USUARIO AS USUARIO_REPARTIDOR ON DESPACHA.ID_USUARIO = USUARIO_REPARTIDOR.ID_USUARIO WHERE USUARIO_REPARTIDOR.ID_USUARIO = '" + id_usu +"';";
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        try {
//            pst = getConexion().prepareStatement(sql);
//            rs = pst.executeQuery();
//            while(rs.next()){
//                totalesrepartido = new totalesReparto();
//                totalesrepartido.setFecha_hora_reparto(rs.getString("FECHA_HORA_DESPACHO"));
//                totalesrepartido.setMonto(rs.getInt("MONTO"));
//                totalesrepartido.setDireccion_despacho(rs.getString("DIRECCION_DESPACHO"));
//                listatotalReparto.add(totalesrepartido);
//            }
//        } catch (Exception e) {
//        }
//        return listatotalReparto;
//    }
    
     public ArrayList<MensualesRepar> listaMenRep(String idUsua, String fechaDesde, String fechaHasta){
        ArrayList<MensualesRepar> listaMensReparto = new ArrayList<>();
        MensualesRepar mensRep;
        String sql = "SELECT DESPACHA.ID_DESPACHO, DESPACHA.FECHA_HORA_DESPACHO, COMPRA.MONTO_REPARTO, DESPACHA.DIRECCION_DESPACHO, COMUNA.NOMBRE_COMUNA AS COMUNA_DESPACHO, USUARIO.NOMBRE AS NOMBRE_CLIENTE, USUARIO.APELLIDOS AS APELLIDOS_CLIENTE FROM DESPACHA INNER JOIN COMPRA ON DESPACHA.ID_COMPRA = COMPRA.ID_COMPRA INNER JOIN USUARIO ON COMPRA.ID_USUARIO = USUARIO.ID_USUARIO INNER JOIN COMUNA ON USUARIO.ID_COMUNA = COMUNA.ID_COMUNA INNER JOIN USUARIO AS USUARIO_REPARTIDOR ON DESPACHA.ID_USUARIO = USUARIO_REPARTIDOR.ID_USUARIO WHERE USUARIO_REPARTIDOR.ID_USUARIO = "+ idUsua +" AND FECHA_HORA_DESPACHO BETWEEN '"+ fechaDesde +"' AND '"+ fechaHasta +"';";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                mensRep = new MensualesRepar();
                mensRep.setID_DESPACHO(rs.getInt("ID_DESPACHO"));
                mensRep.setFECHA_HORA_DESPACHO(rs.getString("FECHA_HORA_DESPACHO"));
                mensRep.setMONTO_REPARTO(rs.getInt("MONTO_REPARTO"));
                mensRep.setDIRECCION_DESPACHO(rs.getString("DIRECCION_DESPACHO"));
                mensRep.setCOMUNA_DESPACHO(rs.getString("COMUNA_DESPACHO"));
                mensRep.setNOMBRE_CLIENTE(rs.getString("NOMBRE_CLIENTE"));
                mensRep.setAPELLIDOS_CLIENTE(rs.getString("APELLIDOS_CLIENTE"));
                listaMensReparto.add(mensRep);
            }
        } catch (Exception e) {
        }
        return listaMensReparto;
    }
     
     public ArrayList<ListaTotalPorRepartidor> listaTotalPorRepartidor(String rutRepartidor){
        ArrayList<ListaTotalPorRepartidor> listaTotalPorRep = new ArrayList<>();
        ListaTotalPorRepartidor totalRep;
        String sql = "SELECT DESPACHA.ID_DESPACHO, DESPACHA.FECHA_HORA_DESPACHO, COMPRA.MONTO_REPARTO, DESPACHA.DIRECCION_DESPACHO, COMUNA.NOMBRE_COMUNA AS COMUNA_DESPACHO, USUARIO.NOMBRE AS NOMBRE_CLIENTE, USUARIO.APELLIDOS AS APELLIDOS_CLIENTE FROM DESPACHA INNER JOIN COMPRA ON DESPACHA.ID_COMPRA = COMPRA.ID_COMPRA INNER JOIN USUARIO ON COMPRA.ID_USUARIO = USUARIO.ID_USUARIO INNER JOIN COMUNA ON USUARIO.ID_COMUNA = COMUNA.ID_COMUNA INNER JOIN USUARIO AS USUARIO_REPARTIDOR ON DESPACHA.ID_USUARIO = USUARIO_REPARTIDOR.ID_USUARIO WHERE USUARIO_REPARTIDOR.RUT = '"+ rutRepartidor +"';";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                totalRep = new ListaTotalPorRepartidor();
                totalRep.setID_DESPACHO(rs.getInt("ID_DESPACHO"));
                totalRep.setFECHA_HORA_DESPACHO(rs.getString("FECHA_HORA_DESPACHO"));
                totalRep.setMONTO_REPARTO(rs.getInt("MONTO_REPARTO"));
                totalRep.setDIRECCION_DESPACHO(rs.getString("DIRECCION_DESPACHO"));
                totalRep.setCOMUNA_DESPACHO(rs.getString("COMUNA_DESPACHO"));
                totalRep.setNOMBRE_CLIENTE(rs.getString("NOMBRE_CLIENTE"));
                totalRep.setAPELLIDOS_CLIENTE(rs.getString("APELLIDOS_CLIENTE"));
                listaTotalPorRep.add(totalRep);
                
            }
        } catch (Exception e) {
        }
        return listaTotalPorRep;
    } 
}
