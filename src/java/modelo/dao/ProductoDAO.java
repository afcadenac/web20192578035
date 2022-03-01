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
import modelo.dto.ProductoDTO;
import modelo.interfaces.Obligacion;

/**
 *
 * @author user
 */
public class ProductoDAO implements Obligacion <ProductoDTO>{
    private static final String SQL_CREATE="INSERT INTO tb_producto(nombre_producto,descripcion_producto,unidades,valor)VALUES(?,?,?,?) ";
    private static final String SQL_DELET="DELETE FROM tb_producto WHERE id_producto=? ";
    private static final String SQL_UPDATE="UPDATE tb_producto set nombre_producto=?,descripcion_producto=?,unidades=?,valor=? WHERE id_producto=? ";
    private static final String SQL_READ="SELECT * FROM tb_producto WHERE id_producto=? ";
    private static final String SQL_READALL="SELECT * FROM tb_producto ";
    
    private static final ConexionMySQL con=ConexionMySQL.getIntance();

    @Override
    public boolean create(ProductoDTO nuevo) {
        try {
            PreparedStatement ps;
            ps=con.getCnn().prepareStatement(SQL_CREATE);
            ps.setString(1, nuevo.getNombre_prod());
            ps.setString(2, nuevo.getDescripcion_prod());
            ps.setInt(3, nuevo.getUnd());
            ps.setLong(4, nuevo.getValor());
            return ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al añadir el producto"+ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ArrayList<ProductoDTO> readAll() {
        ArrayList<ProductoDTO>lista=null;
        try {         
            PreparedStatement ps=con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList();
            while(rs.next()){
                ProductoDTO obj=new ProductoDTO(rs.getInt("id_producto"),rs.getString("nombre_producto"),rs.getString("descripcion_producto"),rs.getInt("unidades"),rs.getLong("valor"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Error al solicitar datos: "+ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return lista;
    }

    @Override
    public ProductoDTO read(ProductoDTO filter) {
        ProductoDTO obj=null;
        try {         
            PreparedStatement ps=con.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, filter.getId_prod());
            ResultSet rs=ps.executeQuery();
            obj=new ProductoDTO(rs.getInt("id_producto"),rs.getString("nombre_producto"),rs.getString("descripcion_producto"),rs.getInt("unidades"),rs.getLong("valor"));
        } catch (SQLException ex) {
            System.out.println("Error al solicitar datos: "+ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return obj;
    }

    @Override
    public boolean update(ProductoDTO item) {
        try {
            PreparedStatement ps;
            ps=con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, item.getNombre_prod());
            ps.setString(2, item.getDescripcion_prod());
            ps.setInt(3, item.getUnd());
            ps.setLong(4, item.getValor());
            return ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos: "+ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(ProductoDTO item) {
        try {
            PreparedStatement ps;
            ps=con.getCnn().prepareStatement(SQL_DELET);
            ps.setInt(1, item.getId_prod());
            return ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar datos: "+ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return false;
    }
    
}
