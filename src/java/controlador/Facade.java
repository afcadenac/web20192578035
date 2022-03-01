/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author user
 */
public class Facade {
    public ArrayList<ProductoDTO> listarProductos(){
        ArrayList<ProductoDTO> lista=null;
        ProductoDAO dao=new ProductoDAO();
        lista=dao.readAll();
        return lista; 
    }
    public boolean borrar(ProductoDTO nuevo){
        ProductoDAO elim=new ProductoDAO();
        return elim.delete(nuevo);
    }
}
