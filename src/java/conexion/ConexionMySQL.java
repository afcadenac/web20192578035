/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ConexionMySQL {
    private static ConexionMySQL intance;
    private Connection cnn;
    private String driver="com.mysql.jdbc.Driver";
    private String user="root";
    private String pss="";
    private String n_bd="bd_tallerjavaweb";
    private String url="jdbc:mysql://localhost:3307/";
    
    private ConexionMySQL(){
        try {
            Class.forName(driver); //llamar al driver y cargarlo (el que esta en la libreria con nombre super "original" xd)
            cnn=DriverManager.getConnection(url+n_bd, user, pss); // devuelve un objeto de tipo Connection para realizar la conexion a la base de datos
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar a la base de datos: "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: "+ex.getMessage());
        } 
    }
    
    public static synchronized ConexionMySQL getIntance(){
        if(intance==null){
            intance=new ConexionMySQL();
        }
        return intance;
    }

    public Connection getCnn() {
        return cnn;
    }
    
    public void cerrarConexion(){
//        if(cnn!=null){
//            try {
//                cnn.close();
//            } catch (SQLException ex) {
//                System.out.println("Error al cerrar la conexion "+ex.getMessage());
//            }
//        }
        intance=null;
    }
    
}
