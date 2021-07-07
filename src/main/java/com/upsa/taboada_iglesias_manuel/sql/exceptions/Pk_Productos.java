/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsa.taboada_iglesias_manuel.sql.exceptions;

/**
 *
 * @author administrador
 */
public class Pk_Productos extends AppException{

    public Pk_Productos() {
    }

    public Pk_Productos(String message) {
        super(message);
    }

    public Pk_Productos(String message, Throwable cause) {
        super(message, cause);
    }

    public Pk_Productos(Throwable cause) {
        super(cause);
    }

    public Pk_Productos(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
