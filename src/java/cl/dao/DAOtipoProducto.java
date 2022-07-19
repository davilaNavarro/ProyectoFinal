/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.TipoProducto;
import cl.model.listaPorProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DAvil
 */
public class DAOtipoProducto extends Conectar{
        public ArrayList<TipoProducto> listartpProd(){
         ArrayList<TipoProducto> lista = new ArrayList<>();
         String sql ="select * from TIPO_PRODUCTO";
         PreparedStatement pst = null;
         ResultSet rs = null;
         try {
              //Se manda la consulta a la base de datos
            pst = getConexion().prepareStatement(sql);
             //Se solicita la ejecuccion de la consulta
            rs = pst.executeQuery();
            while(rs.next()){
               TipoProducto tpProd = new TipoProducto();
                tpProd.setIdTpProd(rs.getInt("ID_TIPO"));
                tpProd.setNombreTpProd(rs.getString("NOMBRE_TIPO"));
                lista.add(tpProd);
            }    
            
         } catch (Exception e) {
         }
         
         return lista;
     } 
        
        public boolean registrarTpProd (String nombreTpProd ) {
        PreparedStatement pst = null;
        try {
              String consulta = "INSERT INTO TIPO_PRODUCTO (NOMBRE_TIPO) values (?)";
              pst = getConexion().prepareStatement(consulta);
              pst.setString(1, nombreTpProd.toUpperCase());
              //Si se inserto el dato
             if(pst.executeUpdate() == 1){
                 return true;
            }
              
        } catch (Exception e) {
        }finally{
           try {
               if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
           } catch (Exception e) {
               System.out.println("Error" + e);
           }
        
        }
        return false;
    }
        
    public ArrayList<listaPorProducto> listaPorTipoProducto(String idTipoProd){
        ArrayList<listaPorProducto> listaPorTipoProd = new ArrayList<>();
        listaPorProducto listaTipProd;
        String sql = "SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.NOMBRE_PRODUCTO, COMPRA.ID_COMPRA, INCORPORA.MONTO_PRODUCTO, COMPRA.FECHA_HORA_COMPRA FROM INCORPORA INNER JOIN PRODUCTO ON INCORPORA.ID_PRODUCTO = PRODUCTO.ID_PRODUCTO INNER JOIN TIPO_PRODUCTO ON PRODUCTO.ID_TIPO = TIPO_PRODUCTO.ID_TIPO INNER JOIN COMPRA ON INCORPORA.ID_COMPRA = COMPRA.ID_COMPRA WHERE TIPO_PRODUCTO.ID_TIPO = "+ idTipoProd +";";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                listaTipProd = new  listaPorProducto();
                listaTipProd.setID_PRODUCTO(rs.getInt("ID_PRODUCTO"));
                listaTipProd.setNOMBRE_PRODUCTO(rs.getString("NOMBRE_PRODUCTO"));
                listaTipProd.setID_COMPRA(rs.getInt("ID_COMPRA"));
                listaTipProd.setMONTO_PRODUCTO(rs.getInt("MONTO_PRODUCTO"));
                listaTipProd.setFECHA_HORA_COMPRA(rs.getString("FECHA_HORA_COMPRA"));
                listaPorTipoProd.add(listaTipProd);
              
                
            }
        } catch (Exception e) {
        }
        return listaPorTipoProd;
    }
    
            public String obtenerTipoProd (int id_tipoProd){
            String obTipoPr = "";
            
            String sql = "SELECT NOMBRE_TIPO FROM TIPO_PRODUCTO WHERE ID_TIPO = '"+ id_tipoProd+ "';";
            PreparedStatement pst = null;
            ResultSet rs = null;
         try {
              //Se manda la consulta a la base de datos
            pst = getConexion().prepareStatement(sql);
             //Se solicita la ejecuccion de la consulta
            rs = pst.executeQuery();
            while (rs.next()) {
                obTipoPr = rs.getString("NOMBRE_TIPO");
            }  
            
         } catch (Exception e) {
         }
            return obTipoPr; 
        }
     
}
