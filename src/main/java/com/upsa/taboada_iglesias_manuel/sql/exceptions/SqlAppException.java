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
public class SqlAppException extends AppException{

    public SqlAppException() {
    }

    public SqlAppException(String message) {
        super(message);
    }

    public SqlAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlAppException(Throwable cause) {
        super(cause);
    }

    public SqlAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
