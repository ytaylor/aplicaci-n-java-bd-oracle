/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsa.taboada_iglesias_manuel.sql;

import java.util.List;


public interface Dao  extends AutoCloseable{
    public Producto insertProducto (String nombre, double pvp, int stock);
    public List<Producto> queryProductosByPvp(double min, double max) ;
    public  List<Producto> queryAllProductos();

}

   