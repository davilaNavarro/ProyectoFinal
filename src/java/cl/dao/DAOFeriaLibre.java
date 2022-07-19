/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dao;

import cl.model.ComboComuna;
import cl.dao.Conectar;
import cl.model.FeriaLibre;
import cl.model.ListaTotalFeria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAvil
 */
public class DAOFeriaLibre extends Conectar {
     public ArrayList<FeriaLibre> listarFeria(){
         ArrayList<FeriaLibre> lista = new ArrayList<>();
         String sql ="select * from FERIA_LIBRE";
         PreparedStatement pst = null;
         ResultSet rs = null;
         try {
              //Se manda la consulta a la base de datos
            pst = getConexion().prepareStatement(sql);
             //Se solicita la ejecuccion de la consulta
            rs = pst.executeQuery();
            while(rs.next()){
               FeriaLibre fer = new FeriaLibre();
                fer.setIdFeria(rs.getInt("ID_FERIA"));
                fer.setNombreFeria(rs.getString("NOMBRE_FERIA"));
                fer.setComunaFeria(rs.getString("ID_COMUNA"));
                fer.setDireccionFeria(rs.getString("DIRECCION_FERIA"));
                lista.add(fer);
            }    
            
         } catch (Exception e) {
         }
         
         return lista;
     }
    
     
     public boolean registrarFeria (String nombreFeria, String comunaFeria, String direccionFeria){
        PreparedStatement pst = null;
        try {
              String consulta = "insert into FERIA_LIBRE (NOMBRE_FERIA, ID_COMUNA, DIRECCION_FERIA) values (?,?,?)";
              pst = getConexion().prepareStatement(consulta);
              pst.setString(1, nombreFeria.toUpperCase());
              pst.setString(2, comunaFeria);
              pst.setString(3, direccionFeria.toUpperCase());
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
     
//        public  static ArrayList<ComboComuna> listarComunas()  {
//         PreparedStatement pst = null;
//            ArrayList<ComboComuna> listaComunas = new ArrayList();
//        ComboComuna comuna;
//        //Preparacion de consulta
//        String consulta = "SELECT * FROM COMUNA; ";
//        try {
//            //String consulta = "insert into FERIA_LIBRE (NOMBRE_FERIA, COMUNA_FERIA, DIRECCION_FERIA) values (?,?,?)";
//              pst = getConexion().prepareStatement(consulta);
//              pst.setString(1, nombreFeria);
//              pst.setString(2, comunaFeria);
//              pst.setString(3, direccionFeria);
//           
//            //ejecutar la consulta.
//            ResultSet res = pst.executeQuery();
//            ArrayList<ComboComuna> lista= new ArrayList<>();
//            ComboComuna communa;
//            //Se recorre el ResultSet.
//            while (res.next()) {
//                comuna = new ComboComuna();
//                comuna.setIdComuna(Integer.parseInt(res.getString("ID_COMUNA")));
//                comuna.setNomComuna(res.getString("NOMBRE_COMUNA"));
//                //Se agrega la comuna a la lista.
//                listaComunas.add(comuna);
//            }
//             return lista;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
     
     
     public ArrayList<ComboComuna> listarComuna(){
         PreparedStatement pst = null;
         ResultSet rs = null;
         
         try {
             
             //Quiero consulta todoas las categorias
            String SQL="select * from COMUNA;";
             pst = getConexion().prepareStatement(SQL);
             rs = pst.executeQuery();
             ArrayList<ComboComuna> lista= new ArrayList<>();
            ComboComuna com;
             //Minetras encuentra un dato en resultado vaya llenandome esa lista
            while(rs.next()){
                //Haga los siguiente
                com = new ComboComuna();
                //Los datos que van entre comillas "" son los nombres de los campos que tienen las tablas
                //Set es para recibir los valores que vienen de algun lugar
                //Get es para obtener o preguntar por el valor que tiene cada uno de los atributos
                //retorna la informacion para mostrar la lista
                com.setIdComuna(Integer.parseInt(rs.getString("ID_COMUNA")));
                com.setNomComuna(rs.getString("NOMBRE_COMUNA"));
                lista.add(com);
            } 
            return lista;
         } catch (Exception e) {
             return null;
         }
     }
     

        public String obtenerComuna (String id_comuna){
            String obComuna = "";
            String sql = "SELECT NOMBRE_COMUNA FROM COMUNA WHERE ID_COMUNA = '"+ id_comuna+ "';";
            PreparedStatement pst = null;
            ResultSet rs = null;
         try {
              //Se manda la consulta a la base de datos
            pst = getConexion().prepareStatement(sql);
             //Se solicita la ejecuccion de la consulta
            rs = pst.executeQuery();
            while (rs.next()) {
                obComuna = rs.getString("NOMBRE_COMUNA");
            }  
            
         } catch (Exception e) {
         }
            return obComuna; 
        }
     
    
     
    //No recibe datos solo los va a enlistar

 
        
     
        public ArrayList <ListaTotalFeria> listaTotalPorFeria (String idFeria){
        ArrayList <ListaTotalFeria> listaPorFeria = new ArrayList<>();
        ListaTotalFeria totalFeria;
        String sql = "SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.NOMBRE_PRODUCTO, INCORPORA.MONTO_PRODUCTO, COMPRA.ID_COMPRA, COMPRA.FECHA_HORA_COMPRA FROM PRODUCTO INNER JOIN USUARIO ON PRODUCTO.ID_USUARIO = USUARIO.ID_USUARIO INNER JOIN INCORPORA ON PRODUCTO.ID_PRODUCTO = INCORPORA.ID_PRODUCTO INNER JOIN COMPRA ON INCORPORA.ID_COMPRA = COMPRA.ID_COMPRA INNER JOIN TRABAJA ON USUARIO.ID_USUARIO = TRABAJA.ID_USUARIO INNER JOIN FERIA_LIBRE ON TRABAJA.ID_FERIA = FERIA_LIBRE.ID_FERIA INNER JOIN COMUNA ON FERIA_LIBRE.ID_COMUNA = COMUNA.ID_COMUNA WHERE COMUNA.ID_COMUNA = "+ idFeria +";";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConexion().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                totalFeria = new ListaTotalFeria();
                totalFeria.setID_PRODUCTO(rs.getInt("ID_PRODUCTO"));
                totalFeria.setNOMBRE_PRODUCTO(rs.getString("NOMBRE_PRODUCTO"));
                totalFeria.setMONTO_PRODUCTO(rs.getInt("MONTO_PRODUCTO"));
                totalFeria.setID_COMPRA(rs.getInt("ID_COMPRA"));
                totalFeria.setFECHA_HORA_COMPRA(rs.getString("FECHA_HORA_COMPRA"));
                listaPorFeria.add(totalFeria);
                                 
            }
        } catch (Exception e) {
        }
        return listaPorFeria;
    }  
}
