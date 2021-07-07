/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsa.taboada_iglesias_manuel.sql;


public class Producto {
    private String ref;
    private String nombre;
    private double pvp;
    private int stock;

    public Producto() {
    }

    public Producto(String ref, String nombre, double pvp, int stock) {
        this.ref = ref;
        this.nombre = nombre;
        this.pvp = pvp;
        this.stock = stock;
    }

    public String getRef() {
        return ref;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPvp() {
        return pvp;
    }

    public int getStock() {
        return stock;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "ref=" + ref + ", nombre=" + nombre + ", pvp=" + pvp + ", stock=" + stock + '}';
    }
   
    
    
}
