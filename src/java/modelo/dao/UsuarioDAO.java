/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.ConexionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.UsuarioDTO;
import modelo.interfaces.Obligacion;

/**
 *
 * @author user
 */
public class UsuarioDAO implements Obligacion<UsuarioDTO>{
    
    private static final String VALIDAR_US="SELECT * FROM tb_usuario WHERE correo=? AND clave=?";
    private static final ConexionMySQL con=ConexionMySQL.getIntance();

    @Override
    public boolean create(UsuarioDTO nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UsuarioDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDTO read(UsuarioDTO filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UsuarioDTO item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(UsuarioDTO item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public UsuarioDTO valSesion(UsuarioDTO item){
        UsuarioDTO nn=null;
        PreparedStatement ps;
        ResultSet rs=null;
        try {
            ps=con.getCnn().prepareStatement(VALIDAR_US);
            ps.setString(1, item.getCorreo());
            ps.setString(2, item.getClave());
            rs=ps.executeQuery();
            if(rs.next()){
                nn=new UsuarioDTO(rs.getInt("id"),rs.getString("nombre1"),rs.getString("nombre2"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("n_identificacion"),rs.getString("correo"), rs.getString("clave"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al validar usuario "+ex.getMessage());
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar result: "+ex.getMessage());
                }
            }
            con.cerrarConexion();
        }
        return nn;
    }
    
}
