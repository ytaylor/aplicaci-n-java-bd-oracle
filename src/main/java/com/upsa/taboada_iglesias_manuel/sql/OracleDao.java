/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsa.taboada_iglesias_manuel.sql;

import com.upsa.taboada_iglesias_manuel.sql.exceptions.Nn_Productos_Nombre;
import com.upsa.taboada_iglesias_manuel.sql.exceptions.Nn_Productos_PVP;
import com.upsa.taboada_iglesias_manuel.sql.exceptions.SqlAppException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

public class OracleDao implements Dao {

    private Connection connection;

    public OracleDao(String url, String username, String password) throws SQLException {

        Driver driver = new OracleDriver();
        DriverManager.registerDriver(driver);

        connection = DriverManager.getConnection(url, username, password);
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public Producto insertProducto(String nombre, double pvp, int stock) {
        Producto prd= new Producto(); 
         String sqlINSERT = "INSERT INTO PRODUCTOS (REF, NOMBRE, PVP, STOCK )"
                + "VALUES ( SEQ_PRODUCTOS.NEXTVAL, ?, ?, ?, ?, ?)                         ";

        String[] fields = new String[]{"REF"};
      
        try ( PreparedStatement statement = connection.prepareStatement(sqlINSERT, fields)) {
            statement.setString(1, nombre);
            statement.setDouble(2, pvp);
            statement.setInt(3, stock);
            statement.executeUpdate();

            try ( ResultSet generatedKeys = statement.getGeneratedKeys()) {
                generatedKeys.next();
                prd.setRef(generatedKeys.getString(1));
            }
            prd.setNombre(nombre);
            prd.setPvp(pvp);
            prd.setStock(stock);
        
        } catch (SQLException ex) {
            String message = ex.getMessage();
            if (message.contains("NN_PRODUCTOS.NOMBRE")) {
                try {
                    throw new Nn_Productos_Nombre("No puede ser un valor nulo");
                } catch (Nn_Productos_Nombre ex1) {
                      System.err.println(message);
                }
            }
            else if (message.contains("NN_PRODUCTOS.PVP")) {
                 System.err.println(message);
            }else{
                 System.err.println(message);
             }
            
        }
        return prd;
    }

    @Override
    public List<Producto> queryProductosByPvp(double min, double max) {
    
        List<Producto> productos = new ArrayList<>();
        String sqlSELECT = "SELECT P.REF, P.NOMBRE, P.PVP, P.STOCK"
                + " FROM PRODUCTOS P                                                    "
                + " WHERE PVP >  ? AND PVP < ? ";

        try ( PreparedStatement statement = connection.prepareStatement(sqlSELECT)) {
            statement.setDouble(1, min);
            statement.setDouble(2, max);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == true) {
                do {
                    Producto prd = new Producto();
                    prd.setRef(resultSet.getString(1));
                    prd.setNombre(resultSet.getString(2));
                    prd.setPvp(resultSet.getDouble(3));
                    prd.setStock(resultSet.getInt(4));
                    productos.add(prd);

                } while (resultSet.next() == true);
            }

        } catch (SQLException ex) {  
            String message = ex.getMessage();
            try {
                throw new SqlAppException(message);
            } catch (SqlAppException ex1) {
             System.err.println(message);

            }
               
        }
        return productos;    
    }

    @Override
    public  List<Producto> queryAllProductos() {
    
        List<Producto> productos = new ArrayList<>();
         String sqlSELECT = "SELECT P.REF, P.NOMBRE, P.PVP, P.STOCK"
                + " FROM PRODUCTOS P                                                    ";

        try ( Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(sqlSELECT);) {
            if (resultSet.next() == true) {
                do {
                    Producto prd = new Producto();
                    prd.setRef(resultSet.getString(1));
                    prd.setNombre(resultSet.getString(2));
                    prd.setPvp(resultSet.getDouble(3));
                    prd.setStock(resultSet.getInt(4));
                    productos.add(prd);

                } while (resultSet.next() == true);

            }

        } catch (SQLException ex) {
            String message = ex.getMessage();
                try {
                throw new SqlAppException(message);
            } catch (SqlAppException ex1) {
             System.err.println(message);

            }
        }
        return productos;
    }

}
