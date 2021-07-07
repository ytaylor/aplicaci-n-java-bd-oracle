/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsa.taboada_iglesias_manuel.sql;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        try ( Dao dao = new OracleDao("jdbc:oracle:thin:@localhost:1521:XE", "mtaboig", "mtaboada")) {

           System.out.println("Producto insertProducto(String nombre, double pvp, int stock)");

            Producto producto = dao.insertProducto("CocaCola", 11.0, 1000);
            System.out.println("El nuevo producto es: " + producto.toString());
            
            
            System.out.println("List<Producto> queryProductosByPvp(double min, double max)");
            List<Producto> productos = dao.queryProductosByPvp(10, 12);
            for (Producto prd : productos) {
                System.out.println(prd.toString());
            }

            System.out.println("List queryAllProductosAsJson()");
            productos = dao.queryAllProductos();
             for (Producto prd : productos) {
                System.out.println(prd.toString());
            }
        }

        try ( Service service = new OracleService("jdbc:oracle:thin:@localhost:1521:XE", "mtaboig", "mtaboada")) {
            String queryAllProductosAsJson = service.queryAllProductosAsJson();
            System.out.println("Formato JSOn todos los productos :");
            System.out.println(queryAllProductosAsJson);

        }

    }

}
