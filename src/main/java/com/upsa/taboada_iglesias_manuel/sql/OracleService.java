/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsa.taboada_iglesias_manuel.sql;

import jakarta.json.bind.JsonbBuilder;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author administrador
 */
public class OracleService implements Service {

    private Dao dao;

    public OracleService(String url, String login, String password) throws SQLException {
        dao = new OracleDao(url, login, password);
    }

    @Override
    public void close() throws Exception {
        this.dao.close();
    }
    private String toJson (List<Producto> productos){
        String json = JsonbBuilder.newBuilder()
                                  .build()
                                  .toJson( productos );
        return json;
    }

    @Override
    public String queryAllProductosAsJson() {
         List<Producto> productos = this.dao.queryAllProductos();
        return toJson(productos);
    }
  
    
    
    
    

}
