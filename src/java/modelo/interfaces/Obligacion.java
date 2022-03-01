/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface Obligacion <cualquiercosa> {
    public boolean create(cualquiercosa nuevo);
    public ArrayList<cualquiercosa> readAll();
    public cualquiercosa read(cualquiercosa filter);
    public boolean update(cualquiercosa item);
    public boolean delete(cualquiercosa item);
}
