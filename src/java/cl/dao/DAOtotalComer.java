/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import static cl.dao.Conectar.getConexion;
import cl.model.CompTotalesComer;
import cl.model.ListaTotalPorComerciante;
import cl.model.MensualesCom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DAvil
 */
public class DAOtotalComer extends Conectar{
     //Lista de ventas totales por comcerciente
    public ArrayList<CompTotalesComer> listaTotalesComer(String idComer){
        ArrayList<CompTotalesComer> listatotalComer = new ArrayList<>();

        CompTotalesComer compTotalesCom;
        String sql = "SELECT PRODUCTO.NOMBRE_PRODUCTO, INCORPORA.CANTIDAD_PRODUCTO * PRODUCTO.COSTO_PRODUCTO AS MONTO, COMPRA.FECHA_HORA_COMPRA FROM PRODUCTO INNER JOIN INCORPORA ON PRODUCTO.ID_PRODUCTO = INCORPORA.ID_PRODUCTO INNER JOIN COMPRA ON COMPRA.ID_COMPRA = INCORPORA.ID_COMPRA WHERE PRODUCTO.ID_USUARIO = '"+ idComer+"';";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                compTotalesCom = new CompTotalesComer();
                compTotalesCom.setNombreProd(rs.getString("NOMBRE_PRODUCTO"));
//                compTotalesCom.setCantidad_prod(rs.getInt("CANTIDAD_PRODUCTO"));
//                compTotalesCom.setCosto_prod(rs.getInt("COSTO_PRODUCTO"));
                compTotalesCom.setMonto(rs.getInt("MONTO"));
                compTotalesCom.setFecha_hora_compra(rs.getString("FECHA_HORA_COMPRA"));
//                compTotalesCom.setId_prod(rs.getInt("ID_PRODUCTO"));
//                compTotalesCom.setId_compra(rs.getInt("ID_COMPRA"));
                //compTotalesCom.setRutConsulta(rut_Comer);
                listatotalComer.add(compTotalesCom);
            }
        } catch (Exception e) {
        }
        return listatotalComer;
    }
    
     public ArrayList<MensualesCom> listaMenCom(String idUsua, String fechaDesde, String fechaHasta){
        ArrayList<MensualesCom> listaMensComerciante = new ArrayList<>();
        MensualesCom mensCom;
        String sql = "SELECT PRODUCTO.NOMBRE_PRODUCTO, INCORPORA.CANTIDAD_PRODUCTO * PRODUCTO.COSTO_PRODUCTO AS MONTO, COMPRA.FECHA_HORA_COMPRA FROM PRODUCTO INNER JOIN INCORPORA ON PRODUCTO.ID_PRODUCTO = INCORPORA.ID_PRODUCTO INNER JOIN COMPRA ON COMPRA.ID_COMPRA = INCORPORA.ID_COMPRA WHERE PRODUCTO.ID_USUARIO = '"+ idUsua +"' AND COMPRA.FECHA_HORA_COMPRA BETWEEN '"+ fechaDesde +"' AND '"+ fechaHasta + "';";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                mensCom = new MensualesCom();
                mensCom.setNOMBRE_PRODUCTO(rs.getString("NOMBRE_PRODUCTO"));
                mensCom.setMONTO(rs.getInt("MONTO"));
                mensCom.setFECHA_HORA_COMPRA(rs.getString("FECHA_HORA_COMPRA"));
                
                
                listaMensComerciante.add(mensCom);
            }
        } catch (Exception e) {
        }
        return listaMensComerciante;
    }
     
        public ArrayList<ListaTotalPorComerciante> listaTotalPorComerciante(String rutComerciante){
         ArrayList<ListaTotalPorComerciante> listaTotalPorCom = new ArrayList<>();
         ListaTotalPorComerciante totalComer;
         String sql = "SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.NOMBRE_PRODUCTO, INCORPORA.MONTO_PRODUCTO, COMPRA.ID_COMPRA, COMPRA.FECHA_HORA_COMPRA FROM PRODUCTO INNER JOIN USUARIO ON PRODUCTO.ID_USUARIO = USUARIO.ID_USUARIO INNER JOIN INCORPORA ON PRODUCTO.ID_PRODUCTO = INCORPORA.ID_PRODUCTO INNER JOIN COMPRA ON INCORPORA.ID_COMPRA = COMPRA.ID_COMPRA WHERE USUARIO.RUT = '"+ rutComerciante +"';";
         PreparedStatement pst = null;
         ResultSet rs = null;
         try {
             pst = getConexion().prepareStatement(sql);
             rs = pst.executeQuery();
             while(rs.next()){
                 totalComer = new ListaTotalPorComerciante();
                 totalComer.setID_PRODUCTO(rs.getInt("ID_PRODUCTO"));
                 totalComer.setNOMBRE_PRODUCTO(rs.getString("NOMBRE_PRODUCTO"));
                 totalComer.setMONTO_PRODUCTO(rs.getInt("MONTO_PRODUCTO"));
                 totalComer.setID_COMPRA(rs.getInt("ID_COMPRA"));
                 totalComer.setFECHA_HORA_COMPRA(rs.getString("FECHA_HORA_COMPRA"));
                 listaTotalPorCom.add(totalComer);

             }
         } catch (Exception e) {
         }
         return listaTotalPorCom;
     } 
}
