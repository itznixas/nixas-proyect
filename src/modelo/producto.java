/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public abstract class producto {
    protected String nombre;
    protected int id_porciones, cantidad;
    protected float precio;

    public producto() {
    }

    public producto(String nombre, int id_porciones, int cantidad, float precio) {
        this.nombre = nombre;
        this.id_porciones = id_porciones;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_porciones() {
        return id_porciones;
    }

    public void setId_porciones(int id_porciones) {
        this.id_porciones = id_porciones;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
