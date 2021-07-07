/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsa.taboada_iglesias_manuel.sql;


/**
 *
 * @author administrador
 */
public interface Service extends AutoCloseable{
    public String queryAllProductosAsJson();
}
